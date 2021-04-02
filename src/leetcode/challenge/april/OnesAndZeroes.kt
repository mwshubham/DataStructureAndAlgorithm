package leetcode.challenge.april

import kotlin.math.max

class OnesAndZeroes {
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
        OnesAndZeroes.findMaxForm(
            arrayOf("10", "0", "1"),
            1,
            1
        )
    )
}