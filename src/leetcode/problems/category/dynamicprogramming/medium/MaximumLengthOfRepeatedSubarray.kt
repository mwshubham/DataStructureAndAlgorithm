package leetcode.problems.category.dynamicprogramming.medium

import kotlin.math.max

/**
 * 718. Maximum Length of Repeated Subarray
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
class MaximumLengthOfRepeatedSubarray {

    /**
     * Runtime: 524 ms, faster than 45.33% of Kotlin online submissions for Maximum Length of Repeated Subarray.
     * Memory Usage: 77 MB, less than 20.15% of Kotlin online submissions for Maximum Length of Repeated Subarray.
     */
    companion object {
        fun findLength(nums1: IntArray, nums2: IntArray): Int {
            if (nums1.isEmpty() || nums2.isEmpty()) return 0
            val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
            var max = 0
            for (i in 0..nums1.size) {
                for (j in 0..nums2.size) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0
                    } else {
                        if (nums1[i - 1] == nums2[j - 1]) {
                            dp[i][j] = 1 + dp[i - 1][j - 1]
                            max = max(max, dp[i][j])
                        }
                    }
                }
            }
            return max
        }
    }
}