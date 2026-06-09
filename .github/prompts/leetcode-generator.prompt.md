---
mode: agent
description: Generate a structured Kotlin solution file for a LeetCode problem. Run this when the user provides a LeetCode URL or asks to set up a new problem.
---

# LeetCode File Generator

Generate a Kotlin solution file for a LeetCode problem by running the generator script.

## Step 1 — Get the LeetCode URL

If the user hasn't provided a URL, ask:
> "Please share the LeetCode problem URL (e.g., https://leetcode.com/problems/two-sum/)"

## Step 2 — Run the Generator

```bash
cd /Users/shubham.agarwal/IdeaProjects/DataStructureAndAlgorithm
python3 leetcode_file_generator.py "${input:leetcodeUrl:LeetCode problem URL}"
```

## Step 3 — Handle Outcomes

### ✅ Success
The script prints:
```
✓ Successfully created: <file-path>
```
Report the file path to the user and offer to open it.

### ⚠️ API Fallback (manual input needed)
The script will prompt for:
1. Problem number (e.g., `1`)  
2. Problem title (e.g., `Two Sum`)  
3. Difficulty — enter `1` (easy), `2` (medium), or `3` (hard)

Provide these values based on what the user told you or what you know about the problem.

### ⚠️ File Already Exists
The script asks `Overwrite? (y/n)`. Confirm with the user before sending `y`.

### ❌ Invalid URL
Verify the URL matches: `https://leetcode.com/problems/<slug>/`
Fix common mistakes (missing trailing slash, wrong domain) and retry.

## Generated File Format

```kotlin
package leetcode.problems.difficulty.<difficulty>

/**
 * <number>. <Title>
 * https://leetcode.com/problems/<slug>/
 */
class <ClassName> {

}
```

| Slug | Class Name | File |
|---|---|---|
| `two-sum` | `TwoSum` | `TwoSum.kt` |
| `max-number-of-k-sum-pairs` | `MaxNumberOfKSumPairs` | `MaxNumberOfKSumPairs.kt` |
