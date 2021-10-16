package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println
import kotlin.math.max

/**
 * 221. Maximal Square
 * https://leetcode.com/problems/maximal-square/
 */
class MaximalSquare {
    companion object {
        /**
         * Runtime: 208 ms, faster than 68.75% of Kotlin online submissions for Maximal Square.
         * Memory Usage: 39.4 MB, less than 81.25% of Kotlin online submissions for Maximal Square.
         */
        fun maximalSquare(matrix: Array<CharArray>): Int {
            if (matrix.isEmpty()) return 0
            val m = matrix.size
            val n = matrix[0].size
            val dp = Array(m) { IntArray(n) }
            var ans = 0
            repeat(m) { i ->
                repeat(n) { j ->
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1
                        ans = 1
                    }
                }
            }

            for (i in 1 until m) {
                for (j in 1 until n) {
                    if (dp[i][j] != 0) {
                        dp[i][j] =
                            1 + minOf(
                                dp[i - 1][j],
                                dp[i][j - 1],
                                dp[i - 1][j - 1]
                            )

                    }
                    ans = max(ans, dp[i][j] * dp[i][j])
                }
            }
            return ans
        }
    }
}

fun main() {
    MaximalSquare.maximalSquare(
        Array(
            5
        ) { CharArray(5) }.apply {
            this[0] = charArrayOf('1', '1', '1', '1', '0')
            this[1] = charArrayOf('1', '1', '1', '1', '0')
            this[2] = charArrayOf('1', '1', '1', '1', '1')
            this[3] = charArrayOf('1', '1', '1', '1', '1')
            this[4] = charArrayOf('0', '0', '1', '1', '1')
        }
    ).println()
}