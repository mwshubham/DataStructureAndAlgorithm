package leetcode.problems

import kotlin.math.max

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */

//[1,2,3,0,2]
//[2,1,4]
class BestTimeToBuyAndSellStockWithCoolDown {
    /**
     * Using LastOperation Machine and array
     * Runtime: 164 ms, faster than 92.86% of Kotlin online submissions for Best Time to Buy and Sell Stock with Cooldown.
     * Memory Usage: 35 MB, less than 7.14% of Kotlin online submissions for Best Time to Buy and Sell Stock with Cooldown.
     */
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) return 0
        val noStockArr = IntArray(prices.size)
        val inHandArr = IntArray(prices.size).apply {
            set(0, -prices[0])
        }
        val soldArr = IntArray(prices.size)
        for (i in 1..prices.lastIndex) {
            noStockArr[i] = max(noStockArr[i - 1], soldArr[i - 1])
            inHandArr[i] = max(inHandArr[i - 1], noStockArr[i - 1] - prices[i])
            soldArr[i] = inHandArr[i - 1] + prices[i]
            println("${noStockArr[i]}, ${inHandArr[i]}, ${soldArr[i]}")
        }
        return max(noStockArr.last(), soldArr.last())
    }

    /**
     * Using LastOperation Machine and previous lastOperation
     * Runtime: 172 ms, faster than 71.43% of Kotlin online submissions for Best Time to Buy and Sell Stock with Cooldown.
     * Memory Usage: 35.1 MB, less than 7.14% of Kotlin online submissions for Best Time to Buy and Sell Stock with Cooldown.
     */
    fun maxProfit2(prices: IntArray): Int {
        if (prices.size <= 1) return 0
        var noStockVal = 0
        var inStockVal = -prices[0]
        var soldVal = 0

        var tempNoStockVal: Int
        var tempInStockVal: Int
        var tempSoldVal: Int

        for (i in 1..prices.lastIndex) {
            tempNoStockVal = noStockVal
            tempInStockVal = inStockVal
            tempSoldVal = soldVal

            noStockVal = max(tempNoStockVal, tempSoldVal)
            inStockVal = max(tempInStockVal, tempNoStockVal - prices[i])
            soldVal = tempInStockVal + prices[i]
            println("$noStockVal, $inStockVal, $soldVal")
        }
        return max(noStockVal, soldVal)
    }


    /**
     * Using Recursion and Memoization
     * optimal sub-structure and repeating sub-problem
     * Runtime: 232 ms, faster than 20.00% of Kotlin online submissions for Best Time to Buy and Sell Stock with Cooldown.
     * Memory Usage: 35.7 MB, less than 45.00% of Kotlin online submissions for Best Time to Buy and Sell Stock with Cooldown.
     */
    fun maxProfit3(prices: IntArray): Int {
        if (prices.size <= 1) return 0
        val memArr = IntArray(prices.size) { -1 }
        return findMax(prices, 0, memArr)
    }

    private fun findMax(prices: IntArray, current: Int, memArr: IntArray): Int {
        if (current > prices.lastIndex) {
            return 0
        }
        if (memArr[current] != -1) {
            return memArr[current]
        }
        var maxVal = 0
        for (i in current..prices.lastIndex) {
            if (prices[i] > prices[current]) {
                maxVal = max(maxVal, prices[i] - prices[current] + findMax(prices, i + 2, memArr))
            }
        }
        maxVal = max(maxVal, findMax(prices, current + 1, memArr))
        memArr[current] = maxVal
        return maxVal
    }
}