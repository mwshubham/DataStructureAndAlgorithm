package leetcode.problems.category.array.medium

import kotlin.math.max

/**
 * 1035. Uncrossed Lines
 * https://leetcode.com/submissions/detail/344794293/?from=/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/
 * https://leetcode.com/problems/uncrossed-lines/
 *
 * Longest Common Subsequence same problem
 */
class UncrossedLines {
    /**
     * Runtime: 288 ms, faster than 66.67% of Kotlin online submissions for Uncrossed Lines.
     * Memory Usage: 39.9 MB, less than 33.33% of Kotlin online submissions for Uncrossed Lines.
     */
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        if (A.isEmpty() || B.isEmpty()) return 0
        val dp = Array(A.size + 1) { IntArray(B.size + 1) }
        for (i in 1..A.size) {
            for (j in 1..B.size) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                } else {
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
                }
            }
        }
        return dp.last().last()
    }
}