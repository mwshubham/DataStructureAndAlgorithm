package leetcode.problems.category.dynamicprogramming.medium

/**
 * 1049. Last Stone Weight II
 * Minimum subset sum difference
 *
 * https://leetcode.com/problems/last-stone-weight-ii/
 */
class LastStoneWeightII {
    companion object {
        /**
         * Runtime: 168 ms, faster than 50.00% of Kotlin online submissions for Last Stone Weight II.
         * Memory Usage: 35.8 MB, less than 50.00% of Kotlin online submissions for Last Stone Weight II.
         */
        fun lastStoneWeightII(stones: IntArray): Int {
            val sum = stones.sum()
            val dp = BooleanArray(sum / 2 + 1)
            dp[0] = true
            for (stone in stones) {
                for (i in dp.lastIndex downTo stone) {
                    dp[i] = dp[i] || dp[i - stone]
                }
            }
            for (i in (sum / 2) downTo 0) {
                if (dp[i]) {
                    return sum - i - i
                }
            }
            return 0
        }
    }
}

fun main() {
    LastStoneWeightII.lastStoneWeightII(intArrayOf(2, 7, 4, 1, 8, 1))
}