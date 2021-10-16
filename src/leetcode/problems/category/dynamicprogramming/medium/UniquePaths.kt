package leetcode.problems.category.dynamicprogramming.medium

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 */
class UniquePaths {
    companion object {
        fun uniquePaths(m: Int, n: Int): Int {
            val dp = Array(m) { IntArray(n) }
            repeat(m) {
                dp[it][0] = 1
            }
            repeat(n) {
                dp[0][it] = 1
            }
            for (i in 1 until m) {
                for (j in 1 until n) {
                    dp[i][j] = 1 + dp[i - 1][j] + dp[i][j - 1]
                }
            }
            return dp.last().last()
        }

        /**
         * Runtime: 136 ms, faster than 64.00% of Kotlin online submissions for Unique Paths.
         * Memory Usage: 35.6 MB, less than 15.33% of Kotlin online submissions for Unique Paths.
         */
        fun uniquePathsUsing1dimensionalDp(m: Int, n: Int): Int {
            val dp = IntArray(n) {1}
            for (i in 1 until m) {
                for (j in 1 until n) {
                    dp[j] += dp[j - 1]
                }
            }
            return dp.last()
        }
    }
}