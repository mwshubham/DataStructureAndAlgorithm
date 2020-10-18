package leetcode.problems

import java.lang.Integer.max
import java.lang.Integer.min

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
class BestTimeToBuyAndSellStock3 {
    /**
     * Runtime: 552 ms, faster than 80.77% of Kotlin online submissions for Best Time to Buy and Sell Stock III.
     * Memory Usage: 56.2 MB, less than 7.69% of Kotlin online submissions for Best Time to Buy and Sell Stock III.
     */
    fun maxProfit(prices: IntArray): Int {
        val left = IntArray(prices.size)
        val right = IntArray(prices.size)

        var lMin = prices.first()
        for (i in 1..prices.lastIndex) {
            left[i] = max(left[i - 1], prices[i] - lMin)
            lMin = min(prices[i], lMin)
        }

        var rMax = prices.last()
        for (i in prices.lastIndex - 1 downTo 0) {
            right[i] = max(right[i + 1], rMax - prices[i])
            rMax = max(prices[i], rMax)
        }
        var profit = right[0]
        for (i in 1..prices.lastIndex) {
            profit = max(profit, left[i - 1] + right[i])
        }
        return profit

    }
}