package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println
import kotlin.math.max

/**
 * 646. Maximum Length of Pair Chain
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 */
class MaximumLengthOfPairChain {
    companion object {

        fun findLongestChainUsingDP(pairs: Array<IntArray>): Int {
            if (pairs.size == 1) return 1
            pairs.sortBy { it[0] }

            val dp = IntArray(pairs.size) { 1 }
            for (i in 1..pairs.lastIndex) {
                for (j in 0 until i) {
                    if (pairs[i][0] > pairs[j][1]) {
                        dp[i] = max(dp[i], dp[j] + 1)
                    }
                }
            }

            return dp.max() ?: 1
        }

        fun findLongestChain(pairs: Array<IntArray>): Int {
            if (pairs.size == 1) return 1
            pairs.sortBy { it[0] }
            var ans = 0
            var prev = Int.MIN_VALUE
            for (pair in pairs) {
                if (pair[0] > prev) {
                    ans++
                    prev = pair[1]
                } else if (pair[1] < prev) {
                    // overlap but with smaller second element
                    prev = pair[1]
                }
            }
            return ans
        }
    }
}

fun main() {
    MaximumLengthOfPairChain.findLongestChain(
        Array(
            3
        ) { intArrayOf(0, 0) }.apply {
            this[0][0] = 1
            this[0][1] = 2

            this[1][0] = 7
            this[1][1] = 8

            this[2][0] = 4
            this[2][1] = 5
        }
    ).println()
}