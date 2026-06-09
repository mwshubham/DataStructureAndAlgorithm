# GitHub Copilot Workspace Instructions

This is a Kotlin DSA project with LeetCode problems organized by difficulty.

## Project Conventions

- Solution files live in `src/leetcode/problems/difficulty/<easy|medium|hard>/`
- Package: `leetcode.problems.difficulty.<difficulty>`
- Class name: PascalCase from the LeetCode slug (e.g., `two-sum` → `TwoSum`)
- Every file starts with a KDoc comment containing the problem number, title, and URL

## Generating Solution Files

> Use the `#leetcode-generator` prompt for step-by-step help generating a new LeetCode solution file.

Never create solution files manually — always use `leetcode_file_generator.py`.
