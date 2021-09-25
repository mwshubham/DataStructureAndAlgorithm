package leetcode

import kotlin1.println

/**
 * 1137. N-th Tribonacci Number
 * https://leetcode.com/problems/n-th-tribonacci-number/
 * https://leetcode.com/explore/featured/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3986/
 */
class NthTribonacciNumber {
    companion object{
        val dp = IntArray(38) { -1 }.apply {
            set(0, 0)
            set(1, 1)
            set(2, 1)
        }

        /**
         * Runtime: 124 ms, faster than 82.19% of Kotlin online submissions for N-th Tribonacci Number.
         * Memory Usage: 32.9 MB, less than 61.64% of Kotlin online submissions for N-th Tribonacci Number.
         */
        fun tribonacci(n: Int): Int {
            if (dp[n] != -1) return dp[n]
            dp[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3)
            return dp[n]
        }
    }
}

fun main(){
    NthTribonacciNumber.tribonacci(0).println()
    NthTribonacciNumber.tribonacci(1).println()
    NthTribonacciNumber.tribonacci(2).println()
    NthTribonacciNumber.tribonacci(3).println()
    NthTribonacciNumber.tribonacci(4).println()
    NthTribonacciNumber.tribonacci(37).println()
}

