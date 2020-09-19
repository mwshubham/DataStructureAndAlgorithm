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
}