import kotlin.math.max

class ZeroOneKnapsack {

    companion object {
        /**
         * 1. Recursion Calls
         * 2. Recursion Calls + Memoization
         * Without Memoization ->  TC: 0(2 pow N)
         * With Memoization ->  TC: 0(NW) Table Size
         */
        lateinit var dp: Array<Array<Int>>

        fun maxProfit(weights: IntArray, profits: IntArray, maxWeight: Int): Int {
            dp = Array(profits.size + 1) {
                Array(maxWeight + 1) {
                    -1
                }
            }
            return knapsack(weights, profits, maxWeight, profits.size)
        }

        private fun knapsack(weights: IntArray, profits: IntArray, space: Int, index: Int): Int {
            if (index == 0 || space == 0) return 0
            if (dp[index][space] != -1) return dp[index][space]

            dp[index][space] = if (weights[index - 1] > space) knapsack(weights, profits, space, index - 1)
            else max(
                knapsack(weights, profits, space, index - 1),
                profits[index - 1] + knapsack(weights, profits, space - weights[index - 1], index - 1)
            )
            return dp[index][space]
        }
    }
}


fun main() {
    val weights = intArrayOf(1, 2, 3)
    val profits = intArrayOf(2, 3, 5)
    println(ZeroOneKnapsack.maxProfit(weights, profits, 1))
    println(ZeroOneKnapsack.maxProfit(weights, profits, 2))
    println(ZeroOneKnapsack.maxProfit(weights, profits, 3))
    println(ZeroOneKnapsack.maxProfit(weights, profits, 4))
    println(ZeroOneKnapsack.maxProfit(weights, profits, 5))
    println(ZeroOneKnapsack.maxProfit(weights, profits, 6))
}