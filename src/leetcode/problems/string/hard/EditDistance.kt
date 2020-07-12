package leetcode.problems.string.hard

// https://leetcode.com/explore/challenge/card/m
// https://www.geeksforgeeks.org/edit-distance-dp-5/
// https://leetcode.com/submissions/detail/347387400/?from=/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3346/
class EditDistance {
    private fun min(x: Int, y: Int, z: Int): Int {
        if (x <= y && x <= z) return x
        return if (y <= x && y <= z) y else z
    }

    fun editDistDP(str1: String, str2: String): Int {
        val m = str1.length
        val n = str2.length
        // Create a table to store results of sub problems
        val dp = Array(m + 1) { IntArray(n + 1) }

        // Fill d[][] in bottom up manner
        for (i in 0..m) {
            for (j in 0..n) {
                // If first string is empty, only option is to
                // insert all characters of second string
                when {
                    i == 0 -> dp[i][j] = j // Min. operations = j
                    j == 0 -> dp[i][j] = i // Min. operations = i
                    str1[i - 1] == str2[j - 1] -> dp[i][j] = dp[i - 1][j - 1]
                    else -> dp[i][j] = 1 + min(
                        dp[i][j - 1],  // Insert
                        dp[i - 1][j],  // Remove
                        dp[i - 1][j - 1]
                    )
                } // Replace
            }
        }
        return dp[m][n]
    }
}