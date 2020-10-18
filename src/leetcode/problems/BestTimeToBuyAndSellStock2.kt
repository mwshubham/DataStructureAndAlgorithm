package leetcode.problems

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
class BestTimeToBuyAndSellStock2 {
    /**
     * Runtime: 200 ms, faster than 49.13% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
     * Runtime: 192 ms, faster than 62.61% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
     * Memory Usage: 40.1 MB, less than 13.48% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
     *
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
}