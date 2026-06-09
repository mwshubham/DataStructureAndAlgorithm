#!/usr/bin/env python3
"""
LeetCode File Generator Agent
Generates Kotlin files for LeetCode problems with proper structure and metadata.
Usage: python3 leetcode_file_generator.py <url>
Example: python3 leetcode_file_generator.py https://leetcode.com/problems/max-number-of-k-sum-pairs/
"""

import sys
import re
import os
import json
import urllib.request
import urllib.error
import ssl
from pathlib import Path
from typing import Optional, Tuple, List


class LeetCodeFileGenerator:
    def __init__(self, base_path: str = "/Users/shubham.agarwal/IdeaProjects/DataStructureAndAlgorithm/src"):
        self.base_path = Path(base_path)
        self.difficulties_path = self.base_path / "leetcode" / "problems" / "difficulty"

    def extract_slug_from_url(self, url: str) -> Optional[str]:
        """Extract problem slug from LeetCode URL."""
        match = re.search(r'problems/([a-z0-9\-]+)', url)
        if match:
            return match.group(1)
        return None

    def slug_to_class_name(self, slug: str) -> str:
        """Convert kebab-case slug to PascalCase class name."""
        words = slug.split('-')
        return ''.join(word.capitalize() for word in words)

    def _make_graphql_request(self, query: dict) -> Optional[dict]:
        """Send a GraphQL POST request to LeetCode and return parsed JSON."""
        ssl_context = ssl.create_default_context()
        ssl_context.check_hostname = False
        ssl_context.verify_mode = ssl.CERT_NONE

        url = "https://leetcode.com/graphql"
        headers = {
            'Content-Type': 'application/json',
            'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)'
        }

        req = urllib.request.Request(
            url,
            data=json.dumps(query).encode('utf-8'),
            headers=headers,
            method='POST'
        )

        with urllib.request.urlopen(req, timeout=10, context=ssl_context) as response:
            return json.loads(response.read().decode('utf-8'))

    def fetch_problem_metadata(self, slug: str) -> Optional[Tuple[str, str, str]]:
        """
        Fetch problem number, difficulty, and title from LeetCode API.
        Returns: (problem_number, difficulty, title) or None if failed
        """
        try:
            query = {
                "query": """
                    query getProblem($titleSlug: String!) {
                        question(titleSlug: $titleSlug) {
                            questionFrontendId
                            difficulty
                            title
                        }
                    }
                """,
                "variables": {"titleSlug": slug}
            }

            result = self._make_graphql_request(query)

            if result and 'data' in result and result['data'] and 'question' in result['data']:
                question = result['data']['question']
                problem_number = question.get('questionFrontendId', 'N/A')
                difficulty = question.get('difficulty', 'medium').lower()
                title = question.get('title', 'Unknown')
                return (problem_number, difficulty, title)
        except Exception as e:
            print(f"Warning: Could not fetch metadata from LeetCode API: {e}", file=sys.stderr)

        return self.prompt_for_metadata()

    def fetch_kotlin_snippet_and_examples(self, slug: str) -> Tuple[Optional[str], List[str]]:
        """
        Fetch the Kotlin code snippet and example inputs from LeetCode API.
        Returns: (kotlin_snippet, example_test_calls)
          - kotlin_snippet: raw Kotlin starter code (e.g. 'fun twoSum(nums: IntArray, target: Int): IntArray { ... }')
          - example_test_calls: list of commented-out test call strings for main()
        """
        try:
            query = {
                "query": """
                    query getProblemDetail($titleSlug: String!) {
                        question(titleSlug: $titleSlug) {
                            codeSnippets {
                                lang
                                langSlug
                                code
                            }
                            exampleTestcaseList
                        }
                    }
                """,
                "variables": {"titleSlug": slug}
            }

            result = self._make_graphql_request(query)

            kotlin_snippet = None
            example_calls = []

            if result and 'data' in result and result['data'] and 'question' in result['data']:
                question = result['data']['question']

                # --- Extract Kotlin code snippet ---
                snippets = question.get('codeSnippets') or []
                for snippet in snippets:
                    if snippet.get('langSlug') == 'kotlin':
                        raw = snippet.get('code', '').strip()
                        # Strip the outer 'class Solution { }' wrapper LeetCode adds
                        kotlin_snippet = self._unwrap_kotlin_snippet(raw)
                        break

                # --- Extract example test cases ---
                example_testcases = question.get('exampleTestcaseList') or []
                if kotlin_snippet and example_testcases:
                    func_name = self._extract_function_name(kotlin_snippet)
                    if func_name:
                        example_calls = self._build_example_calls(
                            func_name, kotlin_snippet, example_testcases
                        )

            return kotlin_snippet, example_calls

        except Exception as e:
            print(f"Warning: Could not fetch code snippet/examples: {e}", file=sys.stderr)
            return None, []

    def _unwrap_kotlin_snippet(self, kotlin_snippet: str) -> str:
        """
        LeetCode wraps Kotlin code in 'class Solution { ... }'.
        Strip that outer wrapper and return only the inner function(s),
        dedented by one level.
        """
        # Match the outer class block (Solution or any class name)
        outer_class_match = re.match(
            r'^\s*class\s+\w+\s*(?:\([^)]*\))?\s*(?::\s*[\w<>(), ]+)?\s*\{',
            kotlin_snippet, re.MULTILINE
        )
        if not outer_class_match:
            return kotlin_snippet

        # Find matching closing brace by counting braces
        start_brace = kotlin_snippet.index('{', outer_class_match.start())
        depth = 0
        end_brace = -1
        for i in range(start_brace, len(kotlin_snippet)):
            if kotlin_snippet[i] == '{':
                depth += 1
            elif kotlin_snippet[i] == '}':
                depth -= 1
                if depth == 0:
                    end_brace = i
                    break

        if end_brace == -1:
            return kotlin_snippet

        inner = kotlin_snippet[start_brace + 1:end_brace]

        # Dedent inner content by 4 spaces
        lines = inner.split('\n')
        dedented_lines = []
        for line in lines:
            if line.startswith('    '):
                dedented_lines.append(line[4:])
            else:
                dedented_lines.append(line)

        return '\n'.join(dedented_lines).strip()

    def _extract_function_name(self, kotlin_snippet: str) -> Optional[str]:
        """Extract the primary function name from a Kotlin snippet."""
        match = re.search(r'\bfun\s+(\w+)\s*\(', kotlin_snippet)
        if match:
            return match.group(1)
        return None

    def _extract_function_signature(self, kotlin_snippet: str) -> Optional[str]:
        """
        Extract a cleaned single-line function signature from the Kotlin snippet.
        e.g. 'fun longestSubarray(nums: IntArray): Int'
        """
        # Match everything from 'fun' up to the opening brace
        match = re.search(r'(fun\s+\w+\s*\([^)]*\)\s*(?::\s*[\w<>, ?!]+)?)\s*\{', kotlin_snippet, re.DOTALL)
        if match:
            sig = match.group(1).strip()
            # Collapse multi-line signatures to one line
            sig = re.sub(r'\s+', ' ', sig)
            return sig
        return None

    def _kotlin_literal(self, value: str, kotlin_type: str) -> str:
        """
        Convert a raw LeetCode example testcase value string to a Kotlin literal
        based on a heuristic match against the detected Kotlin parameter type.
        """
        t = kotlin_type.lower().replace(' ', '')
        value = value.strip()

        # IntArray / Array<Int>
        if 'intarray' in t or t in ('array<int>', 'array<integer>'):
            nums = re.sub(r'[\[\]]', '', value).strip()
            if not nums:
                return 'intArrayOf()'
            return f"intArrayOf({nums})"

        # Array<IntArray> / [[...],[...]]
        if 'array<intarray>' in t or 'int[][]' in t:
            rows = re.findall(r'\[([^\[\]]*)\]', value)
            row_literals = [f"intArrayOf({r.strip()})" for r in rows if r.strip() != '']
            return f"arrayOf({', '.join(row_literals)})"

        # BooleanArray
        if 'booleanarray' in t:
            vals = re.sub(r'[\[\]]', '', value).strip()
            return f"booleanArrayOf({vals})"

        # LongArray
        if 'longarray' in t:
            vals = re.sub(r'[\[\]]', '', value).strip()
            return f"longArrayOf({vals})"

        # DoubleArray
        if 'doublearray' in t:
            vals = re.sub(r'[\[\]]', '', value).strip()
            return f"doubleArrayOf({vals})"

        # CharArray
        if 'chararray' in t:
            vals = re.sub(r'[\[\]]', '', value).strip()
            chars = [f"'{c.strip()}'" for c in vals.split(',') if c.strip()]
            return f"charArrayOf({', '.join(chars)})"

        # Array<String>
        if 'array<string>' in t or 'list<string>' in t:
            items = re.findall(r'"([^"]*)"', value)
            if not items:
                items = [x.strip().strip('"') for x in re.sub(r'[\[\]]', '', value).split(',') if x.strip()]
            quoted = [f'"{i}"' for i in items]
            return f"arrayOf({', '.join(quoted)})"

        # List<Int>
        if 'list<int>' in t:
            nums = re.sub(r'[\[\]]', '', value).strip()
            return f"listOf({nums})"

        # List<List<Int>>
        if 'list<list<int>>' in t:
            rows = re.findall(r'\[([^\[\]]*)\]', value)
            row_literals = [f"listOf({r.strip()})" for r in rows if r.strip() != '']
            return f"listOf({', '.join(row_literals)})"

        # String
        if 'string' in t:
            # Already quoted in raw value?
            if value.startswith('"') and value.endswith('"'):
                return value
            return f'"{value}"'

        # Boolean
        if 'boolean' in t:
            return value.lower()

        # Int, Long, Double — pass through as-is
        return value

    def _build_example_calls(self, func_name: str, kotlin_snippet: str, testcases: List[str]) -> List[str]:
        """
        Build commented-out example call strings for the main() block.
        Each testcase is a newline-separated block of argument values.
        """
        # Extract parameter names + types from signature
        param_match = re.search(r'fun\s+\w+\s*\(([^)]*)\)', kotlin_snippet, re.DOTALL)
        if not param_match:
            return [f"// {func_name}(/* args */).println()"]

        params_str = param_match.group(1).strip()
        if not params_str:
            # No parameters (rare)
            return [f"{func_name}().println()"]

        # Parse individual params: "name: Type"
        param_pairs: List[Tuple[str, str]] = []
        for param in re.split(r',(?![^<>]*>)', params_str):
            param = param.strip()
            colon_idx = param.rfind(':')
            if colon_idx != -1:
                pname = param[:colon_idx].strip()
                ptype = param[colon_idx + 1:].strip()
                param_pairs.append((pname, ptype))
            else:
                param_pairs.append((param, 'Any'))

        calls = []
        for tc in testcases:
            # Each testcase: one arg per line
            arg_lines = [line.strip() for line in tc.strip().split('\n') if line.strip()]

            if len(arg_lines) != len(param_pairs):
                # Mismatch — fall back to generic placeholder
                calls.append(f"// {func_name}(/* {tc.strip()} */).println()")
                continue

            kotlin_args = []
            for (pname, ptype), raw_val in zip(param_pairs, arg_lines):
                kotlin_args.append(self._kotlin_literal(raw_val, ptype))

            calls.append(f"{func_name}({', '.join(kotlin_args)}).println()")

        return calls

    def prompt_for_metadata(self) -> Optional[Tuple[str, str, str]]:
        """Prompt user to manually enter problem metadata."""
        print("\n" + "="*60, file=sys.stderr)
        print("API fetch failed. Please enter problem metadata manually:", file=sys.stderr)
        print("="*60, file=sys.stderr)

        try:
            problem_number = input("Problem number (e.g., 1926): ").strip()
            if not problem_number:
                print("Error: Problem number is required.", file=sys.stderr)
                return None

            title = input("Problem title (e.g., Max Number of K-Sum Pairs): ").strip()
            if not title:
                print("Error: Problem title is required.", file=sys.stderr)
                return None

            print("Difficulty level:", file=sys.stderr)
            print("  1. easy", file=sys.stderr)
            print("  2. medium", file=sys.stderr)
            print("  3. hard", file=sys.stderr)

            difficulty_choice = input("Select difficulty (1-3): ").strip()
            difficulty_map = {'1': 'easy', '2': 'medium', '3': 'hard'}
            difficulty = difficulty_map.get(difficulty_choice, 'medium')

            print(f"✓ Got metadata: #{problem_number} {title} ({difficulty})", file=sys.stderr)
            return (problem_number, difficulty, title)
        except KeyboardInterrupt:
            print("\nAborted.", file=sys.stderr)
            return None
        except Exception as e:
            print(f"Error: {e}", file=sys.stderr)
            return None

    def validate_difficulty(self, difficulty: str) -> bool:
        """Check if difficulty directory exists."""
        difficulty = difficulty.lower()
        valid_dirs = ['easy', 'medium', 'hard']
        if difficulty not in valid_dirs:
            print(f"Error: Invalid difficulty '{difficulty}'. Must be one of: {', '.join(valid_dirs)}", file=sys.stderr)
            return False
        return True

    def generate_kotlin_file(self, url: str) -> bool:
        """
        Main method to generate Kotlin file from LeetCode URL.
        Returns: True if successful, False otherwise
        """
        # Step 1: Extract slug
        slug = self.extract_slug_from_url(url)
        if not slug:
            print(f"Error: Could not extract problem slug from URL: {url}", file=sys.stderr)
            return False

        # Step 2: Fetch metadata
        metadata = self.fetch_problem_metadata(slug)
        if not metadata:
            print(f"Error: Could not fetch problem metadata for slug: {slug}", file=sys.stderr)
            print("Please ensure the URL is valid and the problem exists on LeetCode.", file=sys.stderr)
            return False

        problem_number, difficulty, title = metadata

        # Step 3: Validate difficulty
        if not self.validate_difficulty(difficulty):
            return False

        # Step 4: Generate class name
        class_name = self.slug_to_class_name(slug)

        # Step 5: Fetch Kotlin snippet + example test calls
        kotlin_snippet, example_calls = self.fetch_kotlin_snippet_and_examples(slug)

        # Step 6: Create target directory if it doesn't exist
        difficulty_dir = self.difficulties_path / difficulty
        try:
            difficulty_dir.mkdir(parents=True, exist_ok=True)
        except Exception as e:
            print(f"Error: Could not create directory {difficulty_dir}: {e}", file=sys.stderr)
            return False

        # Step 7: Check if file already exists
        file_path = difficulty_dir / f"{class_name}.kt"
        if file_path.exists():
            print(f"Warning: File already exists at {file_path}", file=sys.stderr)
            response = input("Overwrite? (y/n): ").strip().lower()
            if response != 'y':
                print("Aborted.", file=sys.stderr)
                return False

        # Step 8: Generate Kotlin code
        kotlin_code = self.generate_kotlin_code(
            class_name, problem_number, title, url, difficulty,
            kotlin_snippet, example_calls
        )

        # Step 9: Write file
        try:
            with open(file_path, 'w') as f:
                f.write(kotlin_code)
            print(f"✓ Successfully created: {file_path}")
            return True
        except Exception as e:
            print(f"Error: Could not write file {file_path}: {e}", file=sys.stderr)
            return False

    def generate_kotlin_code(
        self,
        class_name: str,
        problem_number: str,
        title: str,
        url: str,
        difficulty: str,
        kotlin_snippet: Optional[str] = None,
        example_calls: Optional[List[str]] = None,
    ) -> str:
        """Generate the Kotlin file content."""
        package_name = f"leetcode.problems.difficulty.{difficulty.lower()}"

        # --- Build function body ---
        if kotlin_snippet:
            # Indent each line of the snippet by 4 spaces (one level inside the class)
            indented = '\n'.join(
                ('    ' + line) if line.strip() else ''
                for line in kotlin_snippet.splitlines()
            )
            func_body = indented
        else:
            func_body = "    fun solve(): Unit {\n        TODO(\"Not yet implemented\")\n    }"

        # --- Build main() block ---
        if example_calls:
            # First call is active, remaining are commented out
            main_lines = []
            for i, call in enumerate(example_calls):
                if i == 0:
                    main_lines.append(f"        {call}")
                else:
                    if not call.startswith("//"):
                        main_lines.append(f"//        {call}")
                    else:
                        main_lines.append(f"        {call}")
            main_body = '\n'.join(main_lines)
        else:
            main_body = f"        // TODO: add test calls\n        // solve().println()"

        kotlin_code = f"""package {package_name}

import kotlin1.println

/**
 * {problem_number}. {title}
 * {url}
 */
class {class_name} {{

{func_body}
}}

fun main() {{
    {class_name}().apply {{
{main_body}
    }}
}}
"""
        return kotlin_code


def main():
    if len(sys.argv) < 2:
        print("Usage: python3 leetcode_file_generator.py <url>", file=sys.stderr)
        print("Example: python3 leetcode_file_generator.py https://leetcode.com/problems/max-number-of-k-sum-pairs/", file=sys.stderr)
        sys.exit(1)

    url = sys.argv[1]
    generator = LeetCodeFileGenerator()

    success = generator.generate_kotlin_file(url)
    sys.exit(0 if success else 1)


if __name__ == "__main__":
    main()
