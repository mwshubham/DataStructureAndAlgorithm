package leetcode.problems.category.array.easy

import kotlin.math.max

class MaximumSubarray {

    /**
     * Runtime: 176 ms, faster than 84.12% of Kotlin online submissions for Maximum Subarray.
     * Memory Usage: 35.6 MB, less than 66.47% of Kotlin online submissions for Maximum Subarray.
     */
    fun maxSubArray(nums: IntArray): Int {
        var maxSoFar = Int.MIN_VALUE
        var maxEndingHere = 0
        nums.forEach {
            maxEndingHere += it
            maxSoFar = max(maxSoFar, maxEndingHere)
            maxEndingHere = max(0, maxEndingHere)
        }
        return maxSoFar
    }
}