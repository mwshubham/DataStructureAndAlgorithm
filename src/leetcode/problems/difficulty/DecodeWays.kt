package leetcode.problems.difficulty

/**
 * https://leetcode.com/problems/decode-ways/
 */
class DecodeWays {
    companion object {
        /**
         * Runtime: 164 ms, faster than 57.14% of Kotlin online submissions for Decode Ways.
         * Memory Usage: 34.9 MB, less than 63.39% of Kotlin online submissions for Decode Ways.
         */
        fun numDecodings(s: String): Int {
            if (s.isEmpty()) return 0
            val n = s.length
            val dp = Array(n + 1) { 0 }
            dp[0] = 1
            dp[1] = if (s[0] == '0') 0 else 1
            var first: Int
            var second: Int
            for (i in 2..n) {
                first = s.substring(i - 1, i).toInt()
                second = s.substring(i - 2, i).toInt()
                if (first in 1..9) {
                    dp[i] += dp[i - 1]
                }
                if (second in 10..26) {
                    dp[i] += dp[i - 2]
                }
            }
            return dp[n]
        }
    }


}

private fun main() {
    DecodeWays.numDecodings("12")
}