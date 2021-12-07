package leetcode.problems.category.array.medium

import kotlin1.println

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/780/
 * https://leetcode.com/submissions/detail/598309097/?from=explore&item_id=780
 */
class LongestPalindromicSubstring {

    companion object {
        private var start = 0
        private var maxLen = 0

        /**
         * Runtime: 212 ms, faster than 85.78% of Kotlin online submissions for Longest Palindromic Substring.
         * Memory Usage: 35.8 MB, less than 89.39% of Kotlin online submissions for Longest Palindromic Substring.
         */
        fun longestPalindrome(s: String): String {
            start = 0
            maxLen = 0
            if (s.length < 2) return s
            s.forEachIndexed { index, c ->
                longestPalindrome(s, index, index)
                longestPalindrome(s, index, index + 1)
            }
            return s.substring(start, start + maxLen)
        }

        private fun longestPalindrome(s: String, _left: Int, _right: Int) {
            var left = _left
            var right = _right
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                left--
                right++
            }
            if (maxLen < right - left - 1) {
                start = left + 1
                maxLen = right - left - 1
            }
        }
    }
}

fun main() {
    LongestPalindromicSubstring.longestPalindrome("babad").println()
    LongestPalindromicSubstring.longestPalindrome("cbbd").println()
    LongestPalindromicSubstring.longestPalindrome("a").println()
    LongestPalindromicSubstring.longestPalindrome("ac").println()
}