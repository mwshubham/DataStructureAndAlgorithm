# LeetCode File Generator Agent

An intelligent Python agent that automatically generates Kotlin files for LeetCode problems with proper structure, metadata, and directory organization.

## Features

- 🔗 **Automatic Metadata Extraction** - Fetches problem number, difficulty, and title from LeetCode
- 📁 **Smart Directory Organization** - Creates files in the correct `easy/`, `medium/`, or `hard` subdirectory
- 🏛️ **Proper Code Structure** - Generates files with the correct package declaration and KDoc comments
- ↪️ **Fallback Support** - Manual metadata input if API fails
- ⚠️ **Duplicate Protection** - Warns before overwriting existing files

## Installation

No external dependencies required! Uses only Python standard library.

```bash
cd /Users/shubham.agarwal/IdeaProjects/DataStructureAndAlgorithm
```

## Usage

Run the agent with a LeetCode problem URL:

```bash
python3 leetcode_file_generator.py "https://leetcode.com/problems/YOUR-PROBLEM-SLUG/"
```

### Example

```bash
python3 leetcode_file_generator.py "https://leetcode.com/problems/max-number-of-k-sum-pairs/"
```

### Output

Creates a file at: `src/leetcode/problems/difficulty/medium/MaxNumberOfKSumPairs.kt`

With content:
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
2. **Fetch Metadata** - Attempts to fetch problem number, title, and difficulty from LeetCode GraphQL API
3. **Generate Class Name** - Converts kebab-case slug to PascalCase (e.g., `MaxNumberOfKSumPairs`)
4. **Create File** - Generates the Kotlin file in the appropriate difficulty subdirectory
5. **Add Documentation** - Includes problem number, title, and URL in KDoc comments

## Fallback Mechanism

If the API fails to fetch metadata, the agent will prompt you to manually enter:
- Problem number (e.g., `1679`)
- Problem title (e.g., `Max Number of K-Sum Pairs`)
- Difficulty level (1 for easy, 2 for medium, 3 for hard)

## File Structure

```
src/leetcode/problems/difficulty/
├── easy/
│   ├── Problem1.kt
│   ├── Problem2.kt
│   └── ...
├── medium/
│   ├── MaxNumberOfKSumPairs.kt
│   ├── StringCompression.kt
│   └── ...
└── hard/
    ├── Problem1.kt
    └── ...
```

## Naming Convention

The agent uses the following convention for file names:
- Extract slug from URL: `max-number-of-k-sum-pairs`
- Convert to PascalCase: `MaxNumberOfKSumPairs`
- File name: `MaxNumberOfKSumPairs.kt`

## Error Handling

- ✗ Invalid URL format → Shows error message
- ✗ Non-existent problem → Falls back to manual input
- ✗ API failure → Falls back to manual input
- ✗ File already exists → Prompts for overwrite confirmation

## Troubleshooting

### "Could not fetch problem metadata"

This typically means the API is unreachable or the slug is invalid. The agent will prompt you to enter metadata manually.

### "Invalid difficulty"

The problem might not be recognized by LeetCode or the API returned unexpected data. Use the fallback mechanism to manually specify the difficulty.

## Next Steps

- Implement a Kotlin/Gradle wrapper for IDE integration
- Add support for multiple frameworks (Java, Python, etc.)
- Create IDE plugin for one-click file generation
- Add test case generation from LeetCode examples

---

**Created:** May 2026  
**Version:** 1.0  
**Author:** GitHub Copilot

