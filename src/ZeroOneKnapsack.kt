import kotlin.math.max

class ZeroOneKnapsack {

    companion object {
        /**
         * 1. Recursion Calls
         * 2. Recursion Calls + Memoization
         * 3. Using Tabular DP: Top Down
         * Without Memoization ->  TC: 0(2 pow N)
         * With Memoization ->  TC: 0(NW) Table Size
         * Using Tabular DP (Top Down) -> TC: O(nW), SC: O(nW)
         * Using Tabular DP (Bottom UP) -> TC: O(nW), SC: O(nW)
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

        /**
         * Failing this case
         * val weights = intArrayOf(1, 2, 3)
         * val profits = intArrayOf(2, 3, 5)
         * weights, profits, 6
         */
        fun maxProfitUsingTabulationDpTopDown(weights: IntArray, profits: IntArray, maxWeight: Int): Int {
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

        fun maxProfitUsingTabulationDpBottomUp(weights: IntArray, profits: IntArray, maxWeight: Int): Int {
            val dp2 = Array(maxWeight + 1) {
                0
            }
            for (i in weights.indices) {
                for (j in maxWeight downTo weights[i]) {
                    dp2[j] = max(dp2[j], profits[i] + dp2[j - weights[i]])
                }
            }
            return dp2[maxWeight]
        }
    }
}


fun main() {
    val weights = intArrayOf(1, 2, 3)
    val profits = intArrayOf(2, 3, 5)
    println(
        ZeroOneKnapsack.maxProfit(
            weights,
            profits,
            1
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDpBottomUp(weights, profits, 1)
    )
    println(
        ZeroOneKnapsack.maxProfit(
            weights,
            profits,
            2
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDpBottomUp(weights, profits, 2)
    )
    println(
        ZeroOneKnapsack.maxProfit(
            weights,
            profits,
            3
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDpBottomUp(weights, profits, 3)
    )
    println(
        ZeroOneKnapsack.maxProfit(
            weights,
            profits,
            4
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDpBottomUp(weights, profits, 4)
    )
    println(
        ZeroOneKnapsack.maxProfit(
            weights,
            profits,
            5
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDpBottomUp(weights, profits, 5)
    )
    println(
        ZeroOneKnapsack.maxProfit(
            weights,
            profits,
            6
        ) == ZeroOneKnapsack.maxProfitUsingTabulationDpBottomUp(weights, profits, 6)
    )
}