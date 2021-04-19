package leetcode.problems.difficulty

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

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39611/Is-it-Best-Solution-with-O(n)-O(1).
     * Is it Best Solution with O(n), O(1).
     *
     * Runtime: 516 ms, faster than 100.00% of Kotlin online submissions for Best Time to Buy and Sell Stock III.
     * Memory Usage: 55 MB, less than 5.13% of Kotlin online submissions for Best Time to Buy and Sell Stock III.
     */
    fun maxProfit2(prices: IntArray): Int {
        var hold1 = Int.MIN_VALUE
        var hold2 = Int.MIN_VALUE
        var release1 = 0
        var release2 = 0
        for (i in prices) {                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2 + i) // The maximum if we've just sold 2nd stock so far.
            hold2 = Math.max(hold2, release1 - i) // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1 + i) // The maximum if we've just sold 1nd stock so far.
            hold1 = Math.max(hold1, -i) // The maximum if we've just buy  1st stock so far.
        }
        return release2 ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}