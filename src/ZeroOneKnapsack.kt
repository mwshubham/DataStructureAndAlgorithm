import kotlin.math.max

class ZeroOneKnapsack {

    companion object {
        fun maxProfit(weights: IntArray, profits: IntArray, maxWeight: Int): Int {
            return knapsack(weights, profits, maxWeight, 0)
        }

        private fun knapsack(weights: IntArray, profits: IntArray, space: Int, index: Int): Int {
            if (index == weights.size || space == 0) return 0
            return if (weights[index] > space) knapsack(weights, profits, space, index + 1)
            else max(
                knapsack(weights, profits, space, index + 1),
                profits[index] + knapsack(weights, profits, space - weights[index], index + 1)
            )
        }
    }
}


fun main() {
    val weights = intArrayOf(1, 2, 3)
    val profits = intArrayOf(2, 3, 5)
    println(ZeroOneKnapsack.maxProfit(weights, profits, 4))
}