package leetcode.problems.category.dynamicprogramming.medium

import kotlin.math.max

/**
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/
 */
class LongestCommonSubsequence {
    companion object{
        /**
         * Runtime: 164 ms, faster than 73.97% of Kotlin online submissions for Longest Common Subsequence.
         * Memory Usage: ˚39.1 MB, less than 65.75% of Kotlin online submissions for Longest Common Subsequence.
         */
        fun longestCommonSubsequence(text1: String, text2: String): Int {
            if (text1.isEmpty() || text2.isEmpty()) return 0
            val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }
            var max = 0
            for (i in 1..text1.length) {
                for (j in 1..text2.length) {
                    if (text1[i - 1] == text2[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1]
                    } else {
                        dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
                    }
                }
            }
            return dp.last().last()
        }
    }
}