package leetcode.problems.array.easy

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3464/
// https://leetcode.com/submissions/detail/397730657/?from=/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3464/
class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        if (prices.isEmpty()) return profit
        var buyAt = prices[0]
        for (index in 1..prices.lastIndex) {
            if (prices[index] - buyAt > profit) {
                profit = prices[index] - buyAt
            }
            if (prices[index] < buyAt) {
                buyAt = prices[index]
            }
        }
        return profit
    }


    /**
     * Time complexity : O(n). Only a single pass is needed.
     * Space complexity : O(1). Only two variables are used.
     */
    fun maxProfit2(prices: IntArray): Int {
        var minprice = Int.MAX_VALUE
        var maxprofit = 0
        for (i in prices.indices) {
            if (prices[i] < minprice) minprice = prices[i]
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice
        }
        return maxprofit
    }
}