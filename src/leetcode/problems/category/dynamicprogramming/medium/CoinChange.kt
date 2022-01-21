package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println
import kotlin.math.max
import kotlin.math.min

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 *
 * Constraints:
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */

//[1,2,5]
//11
//[2]
//3
//[1]
//0
//[1]
//1
//[1]
//2
//[2]
//1
//[2, 5, 10, 1]
//27
class CoinChange {
    companion object{
        /**
         * Runtime: 176 ms, faster than 66.18% of Kotlin online submissions for Coin Change.
         * Memory Usage: 36.9 MB, less than 31.62% of Kotlin online submissions for Coin Change.
         */
        fun coinChange(coins: IntArray, amount: Int): Int {
            if (amount == 0) return 0
            val dp = IntArray(amount + 1)
            dp[0] = 0
            for (i in 1..dp.lastIndex){
                // Not Int.MAX_VALUE to prevent overflow.
                dp[i] = amount + 1
            }
            dp.println()
            for (i in coins.indices){
                if (coins[i] > amount) continue
                for (j in coins[i]..amount){
                    dp[j] = min(dp[j], 1 + dp[j - coins[i]])
                }

                dp.println()
            }
            return  max(-1, dp.last())
                .takeIf { it <= amount }
                ?: -1
        }
    }
}

fun main(){
    println("Input -> \nCoins [1,2, 5]\nAmount: 11")
    println("DP -> ")
    CoinChange.coinChange(intArrayOf(1,2, 5), 11).apply {
        println("Solution: $this")
    }
    println()
    println("Input -> \nCoins [2]\nAmount: 1")
    println("DP -> ")
    CoinChange.coinChange(intArrayOf(2), 1).apply {
        println("Solution: $this")
    }
    println()
    println("Input -> \nCoins [1]\nAmount: 0")
    println("DP -> ")
    CoinChange.coinChange(intArrayOf(1), 0).apply {
        println("Solution: $this")
    }
    println()
    println("Input -> \nCoins [1]\nAmount: 1")
    println("DP -> ")
    CoinChange.coinChange(intArrayOf(1), 1).apply {
        println("Solution: $this")
    }
    println()
    println("Input -> \nCoins [1]\nAmount: 2")
    println("DP -> ")
    CoinChange.coinChange(intArrayOf(1), 2).apply {
        println("Solution: $this")
    }
}