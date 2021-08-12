package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println

/**
 * 518. Coin Change 2
 * https://leetcode.com/problems/coin-change-2/
 */
class CoinChange2 {
    companion object{
        /**
         * Runtime: 156 ms, faster than 72.00% of Kotlin online submissions for Coin Change 2.
         * Memory Usage: 35.8 MB, less than 64.00% of Kotlin online submissions for Coin Change 2.
         */
        fun change(amount: Int, coins: IntArray): Int {
            if (amount == 0) return 0
            val dp = IntArray(amount + 1)
            dp[0] = 1
            dp.println()
            for (i in coins.indices){
                if (coins[i] > amount) continue
                for (j in coins[i]..amount){
                    dp[j] += dp[j - coins[i]]
                }
                dp.println()
            }
            return  dp.last()
        }
    }
}

fun main(){
    println("Input -> \nCoins [1,2, 5]\nAmount: 5")
    println("DP -> ")
    CoinChange2.change(5, intArrayOf(1,2, 5)).apply {
        println("Solution: $this")
    }
    println()
    println("Input -> \nCoins [1,2, 5]\nAmount: 11")
    println("DP -> ")
    CoinChange2.change(11, intArrayOf(1,2, 5)).apply {
        println("Solution: $this")
    }
    println()
    println("Input -> \nCoins [2]\nAmount: 1")
    println("DP -> ")
    CoinChange2.change(1, intArrayOf(2)).apply {
        println("Solution: $this")
    }
    println()
    println("Input -> \nCoins [1]\nAmount: 0")
    println("DP -> ")
    CoinChange2.change(0, intArrayOf(1)).apply {
        println("Solution: $this")
    }
    println()
    println("Input -> \nCoins [1]\nAmount: 1")
    println("DP -> ")
    CoinChange2.change(1, intArrayOf(1)).apply {
        println("Solution: $this")
    }
    println()
    println("Input -> \nCoins [1]\nAmount: 2")
    println("DP -> ")
    CoinChange2.change(2, intArrayOf(1)).apply {
        println("Solution: $this")
    }
}