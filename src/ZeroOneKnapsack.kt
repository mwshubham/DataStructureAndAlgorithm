import kotlin.math.max

class ZeroOneKnapsack {

    companion object {
        /**
         * 1. Recursion Calls
         * 2. Recursion Calls + Memoization
         * 3. Using Tabular DP
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

        fun maxProfitUsingTabulationDp(weights: IntArray, profits: IntArray, maxWeight: Int): Int {
            dp = Array(profits.size + 1) {
                Array(maxWeight + 1) {
                    0
                }
            }
            repeat(weights.size + 1) { i ->
                repeat(maxWeight + 1) { j ->
                    if (i == 0 || j == 0) dp[i][j] = 0
                    else if (weights[i - 1] > j) dp[i][j] = dp[i - 1][j]
                    else dp[i][j] = max(dp[i - 1][j], profits[i - 1] + dp[i - 1][maxWeight - weights[i - 1]])
//                    println("dp[$i][$j] = ${dp[i][j]}")
                }
            }
            return dp[profits.size][maxWeight]
        }
    }
}


fun main() {
    val weights = intArrayOf(1, 2, 3)
    val profits = intArrayOf(2, 3, 5)
    println(
        ZeroOneKnapsack.maxProfitUsingTabulationDp(
            weights,
            profits,
            1
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDp(weights, profits, 1)
    )
    println(
        ZeroOneKnapsack.maxProfitUsingTabulationDp(
            weights,
            profits,
            2
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDp(weights, profits, 2)
    )
    println(
        ZeroOneKnapsack.maxProfitUsingTabulationDp(
            weights,
            profits,
            3
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDp(weights, profits, 3)
    )
    println(
        ZeroOneKnapsack.maxProfitUsingTabulationDp(
            weights,
            profits,
            4
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDp(weights, profits, 4)
    )
    println(
        ZeroOneKnapsack.maxProfitUsingTabulationDp(
            weights,
            profits,
            5
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDp(weights, profits, 5)
    )
    println(
        ZeroOneKnapsack.maxProfitUsingTabulationDp(
            weights,
            profits,
            6
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDp(weights, profits, 6)
    )
}