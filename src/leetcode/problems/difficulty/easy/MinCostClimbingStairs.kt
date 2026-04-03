package leetcode.problems.difficulty.easy

import kotlin.math.min

/**
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs
 */
class MinCostClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        if (n <= 1) return 0
        if (n == 2) return min(cost[0], cost[1])
        val dp = IntArray(n + 1){ - 1}
        return minCostClimbingStairs(cost, dp, -1, n)
    }


    fun minCostClimbingStairs(costArr: IntArray, dp: IntArray, i: Int, n: Int): Int {
        if (i + 2 >= n) return costArr[i]
        if (dp[i + 1] != -1) return dp[i + 1]
        val cost = if (i == -1) 0 else costArr[i]
        dp[i + 1] = cost + min(
            minCostClimbingStairs(costArr, dp, i + 1, n),
            minCostClimbingStairs(costArr, dp, i + 2, n)
        )
        return dp[i + 1]
    }
}
