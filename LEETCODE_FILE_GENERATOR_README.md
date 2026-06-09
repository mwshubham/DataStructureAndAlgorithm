# LeetCode File Generator

An intelligent Python script that automatically generates Kotlin files for LeetCode problems with proper structure, metadata, and directory organization.

## Features

- 🔗 **Automatic Metadata Extraction** - Fetches problem number, difficulty, and title from LeetCode GraphQL API
- 📁 **Smart Directory Organization** - Creates files in the correct `easy/`, `medium/`, or `hard/` subdirectory
- 🏛️ **Proper Code Structure** - Generates files with the correct package declaration and KDoc comments
- ↪️ **Fallback Support** - Manual metadata input if API fails
- ⚠️ **Duplicate Protection** - Warns before overwriting existing files
- 🤖 **AI Skill Integration** - Invoke via Antigravity IDE with natural language

## Installation

No external dependencies required! Uses only the Python standard library.

```bash
cd /Users/shubham.agarwal/IdeaProjects/DataStructureAndAlgorithm
```

## Usage

### Option 1: Run Directly

```bash
python3 leetcode_file_generator.py "https://leetcode.com/problems/YOUR-PROBLEM-SLUG/"
```

### Option 2: Use the AI Skill (Recommended)

In the Antigravity IDE, simply say:

> "Generate a LeetCode file for https://leetcode.com/problems/two-sum/"

The `leetcode-file-generator` skill will automatically run the script and report the created file path.

### Example

```bash
python3 leetcode_file_generator.py "https://leetcode.com/problems/max-number-of-k-sum-pairs/"
```

### Output

Creates a file at: `src/leetcode/problems/difficulty/medium/MaxNumberOfKSumPairs.kt`

```kotlin
package leetcode.problems.difficulty.medium

/**
 * 1679. Max Number of K-Sum Pairs
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 */
class MaxNumberOfKSumPairs {

}
```

## How It Works

1. **Extract Slug** - Parses the URL to extract the problem slug (e.g., `max-number-of-k-sum-pairs`)
2. **Fetch Metadata** - Fetches problem number, title, and difficulty from LeetCode GraphQL API
3. **Generate Class Name** - Converts kebab-case slug to PascalCase (e.g., `MaxNumberOfKSumPairs`)
4. **Create File** - Generates the Kotlin file in the appropriate difficulty subdirectory
5. **Add Documentation** - Includes problem number, title, and URL in KDoc comments

## Fallback Mechanism

If the API fails to fetch metadata, the script will prompt you to manually enter:
- Problem number (e.g., `1679`)
- Problem title (e.g., `Max Number of K-Sum Pairs`)
- Difficulty level (1 for easy, 2 for medium, 3 for hard)

## File Structure

```
src/leetcode/problems/difficulty/
├── easy/
│   ├── TwoSum.kt
│   └── ...
├── medium/
│   ├── MaxNumberOfKSumPairs.kt
│   ├── StringCompression.kt
│   └── ...
└── hard/
    └── ...
```

## Naming Convention

| URL Slug                    | Class Name               | File Name                    |
|-----------------------------|--------------------------|------------------------------|
| `two-sum`                   | `TwoSum`                 | `TwoSum.kt`                  |
| `max-number-of-k-sum-pairs` | `MaxNumberOfKSumPairs`   | `MaxNumberOfKSumPairs.kt`    |

## Error Handling

| Scenario | Behavior |
|---|---|
| Invalid URL format | Shows error message |
| Non-existent problem | Falls back to manual input |
| API failure | Falls back to manual input |
| File already exists | Prompts for overwrite confirmation |

## AI Skill Plugin

The `leetcode-file-generator` skill is installed at:

```
~/.gemini/config/plugins/leetcode-plugin/skills/SKILL.md
```

This allows the Antigravity IDE to automatically invoke the generator when you mention a LeetCode URL or ask to generate a file.

## Troubleshooting

### "Could not fetch problem metadata"

The API is unreachable or the slug is invalid. The script will prompt you to enter metadata manually.

### "Invalid difficulty"

The problem might not be recognized by LeetCode or the API returned unexpected data. Use the fallback mechanism to manually specify the difficulty.

## Next Steps

- [ ] Add support for multiple languages (Java, Python, etc.)
- [ ] Add test case generation from LeetCode examples
- [ ] Create Gradle task for IDE integration

---

**Created:** May 2026  
**Version:** 1.1  
**Author:** Shubham Agarwal
