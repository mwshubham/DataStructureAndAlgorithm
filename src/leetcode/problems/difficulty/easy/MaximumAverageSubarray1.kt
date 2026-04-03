package leetcode.problems.difficulty.easy

/**
 * 643. Maximym Average Subarray 1
 * https://leetcode.com/problems/maximum-average-subarray-i
 */
class MaximumAverageSubarray1 {

    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val n = nums.size
        if (k >= n) return nums.average()
        var maxAvg = 0.0
        var sum = 0.0
        for (i in 0 until k) {
            sum += nums[i]
        }
        maxAvg = sum
        for (i in 1..n - k) {
            sum += nums[i + k - 1]  - nums[i - 1]
            maxAvg = Math.max(maxAvg, sum)
        }

        return maxAvg  / k
    }
}