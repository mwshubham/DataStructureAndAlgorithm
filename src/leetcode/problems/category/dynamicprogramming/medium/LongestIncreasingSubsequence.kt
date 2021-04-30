package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
//[0,3,1,6,2,2,7]
//[10,9,2,5,3,7,101,18]
//[0,1,0,3,2,3]
//[7,7,7,7,7,7,7]
class LongestIncreasingSubsequence {
    /**
     * Runtime: 336 ms, faster than 31.82% of Kotlin online submissions for Longest Increasing Subsequence.
     * Memory Usage: 37.6 MB, less than 40.00% of Kotlin online submissions for Longest Increasing Subsequence.
     */
    companion object {
        fun lengthOfLIS(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            val dp = IntArray(nums.size) { 1 }
            var result = 1
            for (i in 1..nums.lastIndex) {
                for (j in 0 until i) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i])
                    }
                }
                result = Math.max(result, dp[i])
            }
            return result
        }
    }
}


fun main() {
//    LongestIncreasingSubsequence.lengthOfLIS(intArrayOf(0, 3, 1, 6, 2, 2, 7)).println()
    LongestIncreasingSubsequence.lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)).println()
}