package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println
import kotlin.math.min
import kotlin.math.sqrt

/**
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/
 */
class PerfectSquares {
    companion object{
        /**
         * Runtime: 196 ms, faster than 87.85% of Kotlin online submissions for Perfect Squares.
         * Memory Usage: 36 MB, less than 65.19% of Kotlin online submissions for Perfect Squares.
         */
        fun numSquares(n: Int): Int {
            val a = sqrt(n.toFloat()).toInt()
            if (a*a == n) return 1
            if (n <= 3) return n
            val dp = IntArray(n + 1)
            dp[0] = 0
            dp[1] = 1
            dp[2] = 2
            dp[3] = 3
            for (i in 4..dp.lastIndex) {
                dp[i] = i
                var j = 1
                while (j * j <= i) {
                    dp[i] = min(dp[i], 1 + dp[i - j * j])
                    j++
                }
            }
            return dp.last()
        }
    }
}

fun main(){
    PerfectSquares.numSquares(12).println()
}