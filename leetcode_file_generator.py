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
from typing import Optional, Tuple


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

    def fetch_problem_metadata(self, slug: str) -> Optional[Tuple[str, str, str]]:
        """
        Fetch problem number, difficulty, and title from LeetCode API.
        Returns: (problem_number, difficulty, title) or None if failed
        """
        try:
            # Create SSL context that doesn't verify certificates (for development)
            ssl_context = ssl.create_default_context()
            ssl_context.check_hostname = False
            ssl_context.verify_mode = ssl.CERT_NONE

            # Try LeetCode GraphQL API
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
                "variables": {
                    "titleSlug": slug
                }
            }

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
                result = json.loads(response.read().decode('utf-8'))

                if 'data' in result and result['data'] and 'question' in result['data']:
                    question = result['data']['question']
                    problem_number = question.get('questionFrontendId', 'N/A')
                    difficulty = question.get('difficulty', 'medium').lower()
                    title = question.get('title', 'Unknown')
                    return (problem_number, difficulty, title)
        except Exception as e:
            print(f"Warning: Could not fetch from LeetCode API: {e}", file=sys.stderr)

        # Fallback: prompt user for metadata
        return self.prompt_for_metadata()

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

        # Step 5: Create target directory if it doesn't exist
        difficulty_dir = self.difficulties_path / difficulty
        try:
            difficulty_dir.mkdir(parents=True, exist_ok=True)
        except Exception as e:
            print(f"Error: Could not create directory {difficulty_dir}: {e}", file=sys.stderr)
            return False

        # Step 6: Check if file already exists
        file_path = difficulty_dir / f"{class_name}.kt"
        if file_path.exists():
            print(f"Warning: File already exists at {file_path}", file=sys.stderr)
            response = input("Overwrite? (y/n): ").strip().lower()
            if response != 'y':
                print("Aborted.", file=sys.stderr)
                return False

        # Step 7: Generate Kotlin code
        kotlin_code = self.generate_kotlin_code(class_name, problem_number, title, url)

        # Step 8: Write file
        try:
            with open(file_path, 'w') as f:
                f.write(kotlin_code)
            print(f"✓ Successfully created: {file_path}")
            return True
        except Exception as e:
            print(f"Error: Could not write file {file_path}: {e}", file=sys.stderr)
            return False

    def generate_kotlin_code(self, class_name: str, problem_number: str, title: str, url: str) -> str:
        """Generate the Kotlin file content."""
        difficulty = url.split('/')[-2]
        metadata = self.fetch_problem_metadata(self.extract_slug_from_url(url))
        if metadata:
            difficulty = metadata[1].lower()

        package_name = f"leetcode.problems.difficulty.{difficulty}"

        kotlin_code = f"""package {package_name}

/**
 * {problem_number}. {title}
 * {url}
 */
class {class_name} {{

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


