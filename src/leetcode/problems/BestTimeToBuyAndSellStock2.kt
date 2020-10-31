package leetcode.problems

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
class BestTimeToBuyAndSellStock2 {
    /**
     * Runtime: 200 ms, faster than 49.13% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
     * Runtime: 192 ms, faster than 62.61% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
     * Memory Usage: 40.1 MB, less than 13.48% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
     */
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var i = 0
        while (i < prices.size) {
            while (i < prices.lastIndex && prices[i + 1] <= prices[i]) {
                i++
            }
            val min = prices[i++]
            while (i < prices.lastIndex && prices[i + 1] >= prices[i]) {
                i++
            }
            profit += if (i < prices.size) prices[i++] - min else 0
        }
        return profit
    }

    /**
     * Peak Valley Approach
     * Runtime: 216 ms, faster than 25.11% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
     * Memory Usage: 39.8 MB, less than 17.32% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
     */
    fun maxProfit2(prices: IntArray): Int {
        var i = 0
        var valley: Int
        var peak: Int
        var maxprofit = 0
        while (i < prices.lastIndex) {
            while (i < prices.lastIndex && prices[i] >= prices[i + 1]) i++
            valley = prices[i]
            while (i < prices.lastIndex && prices[i] <= prices[i + 1]) i++
            peak = prices[i]
            maxprofit += peak - valley
        }
        return maxprofit
    }

    /**
     * Simple One Pass Approach
     * Runtime: 176 ms, faster than 91.77% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
     * Memory Usage: 34.4 MB, less than 17.32% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
     */
    fun maxProfit3(prices: IntArray): Int {
        var maxprofit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) maxprofit += prices[i] - prices[i - 1]
        }
        return maxprofit
    }
}