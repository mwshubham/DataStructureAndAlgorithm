package leetcode.problems.category.array.medium

/**
 *
 * DP Problem.
 * https://leetcode.com/submissions/detail/344794293/?from=/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/
 * https://leetcode.com/problems/uncrossed-lines/
 *
 * https://dev.to/chakrihacker/uncrossed-lines-leetcode-4h2h
 */
class UncrossedLines {
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        val sizeA = A.size
        val sizeB = B.size

        val dp = Array(sizeA) { IntArray(sizeA) }

        for (i in 0 until sizeA) {
            for (j in 0 until sizeB) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                } else {
                    dp[i][j] = dp[i - 1][j].coerceAtLeast(dp[i][j - 1])
                }
            }
        }
        return dp[sizeA][sizeB]
    }
}