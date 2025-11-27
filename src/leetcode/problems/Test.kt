package leetcode.problems

import kotlin1.println

class Solution {

    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 1) return 0
        var buyAt = Int.MAX_VALUE
        var maxProfit = 0
        for (price in prices) {
            if (price < buyAt) {
                buyAt = price
            } else if (price - buyAt > 0) {
                maxProfit += price - buyAt
                buyAt = price
            }
        }
        return maxProfit
    }
}

fun main() {
    Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)).println()
}