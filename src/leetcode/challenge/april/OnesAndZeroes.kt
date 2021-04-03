package leetcode.challenge.april

import kotlin.math.max

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3694/
 */
class OnesAndZeroes {
    //    ["10","0001","111001","1","0"]
//    5
//    3
//    ["10","0","1"]
//    1
//    1
//    ["101","110","0","0","0","0001","1010","01","10110","0011","0","10","11","110","1","10","0","1","00","1","0","010","1","000","0","101","0","11","1","01111","110000","1","01"]
//    47
//    88
    companion object {
        private lateinit var dp: Array<Array<Array<Int>>>
        fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
            dp = Array(strs.size + 1) {
                Array(m + 1) {
                    Array(n + 1) { -1 }
                }
            }
            return findMaxForm(strs, m, n, 0)
        }

        private fun findMaxForm(strs: Array<String>, m: Int, n: Int, index: Int): Int {
            if (strs.size == index) return 0
            if (dp[index][m][n] != -1) return dp[index][m][n]
            val zeros = strs[index].filter { c -> c == '0' }.length
            val ones = strs[index].length - zeros
            dp[index][m][n] =
                if (zeros > m || ones > n) findMaxForm(strs, m, n, index + 1)
                else max(
                    findMaxForm(strs, m, n, index + 1),
                    1 + findMaxForm(strs, m - zeros, n - ones, index + 1)
                )
            return dp[index][m][n]
        }

        fun findMaxFormUsingTabularDpTopDown(strs: Array<String>, m: Int, n: Int): Int {
            dp = Array(strs.size + 1) {
                Array(m + 1) {
                    Array(n + 1) { 0 }
                }
            }
            repeat(strs.size + 1) { i ->
                val zeros = strs.getOrNull(i - 1)?.filter { c -> c == '0' }?.length ?: 0
                val ones = strs.getOrNull(i - 1)?.length ?: 0 - zeros
                repeat(m + 1) { j ->
                    repeat(n + 1) { k ->
                        if (i == 0 || j == 0 || k == 0) dp[i][j][k] = 0
                        else if (zeros > m || ones > n) dp[i][j][k] = dp[i - 1][j][k]
                        else dp[i][j][k] = max(dp[i - 1][j][k], 1 + dp[i - 1][m - zeros][n - ones])
                    }
                }
            }
            return dp[strs.size][m][n]
        }

        /**
         * Runtime: 268 ms, faster than 50.00% of Kotlin online submissions for Ones and Zeroes.
         * Memory Usage: 34.9 MB, less than 100.00% of Kotlin online submissions for Ones and Zeroes.
         */
        fun findMaxFormUsingTabularDpBottomUp(strs: Array<String>, m: Int, n: Int): Int {
            val dp2 = Array(m + 1) {
                Array(n + 1) { 0 }
            }
            var zeros: Int
            var ones: Int
            for (i in strs.indices) {
                zeros = strs[i].filter { c -> c == '0' }.length
                ones = strs[i].length - zeros
                for (j in m downTo zeros) {
                    for (k in n downTo ones) {
                        dp2[j][k] = max(dp2[j][k], 1 + dp2[j - zeros][k - ones])
                    }
                }
            }
            return dp2[m][n]
        }
    }
}

//["10","0001","111001","1","0"]
//5
//3
//["10","0","1"]
//1
//1
//["101","110","0","0","0","0001","1010","01","10110","0011","0","10","11","110","1","10","0","1","00","1","0","010","1","000","0","101","0","11","1","01111","110000","1","01"]
//47
//88
fun main() {
    println(
        OnesAndZeroes.findMaxFormUsingTabularDpTopDown(
            arrayOf("10", "0001", "111001", "1", "0"),
            5,
            3
        )
    )
//    println(
//        OnesAndZeroes.findMaxFormUsingTabularDp(
//            arrayOf("10", "0", "1"),
//            1,
//            1
//        )
//    )
}