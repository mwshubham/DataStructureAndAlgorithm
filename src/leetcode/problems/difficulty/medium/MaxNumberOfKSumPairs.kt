package leetcode.problems.difficulty.medium

/**
 * 1679. Max Number of K-Sum Pairs
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 */
class MaxNumberOfKSumPairs {
    // 1 2 3 4 5
    fun maxOperations(nums: IntArray, k: Int): Int {
        var operation = 0
        nums.sort()
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val sum = nums[left] + nums[right]
            if (sum == k) {
                left++
                right--
                operation++
            } else if (sum < k) {
                left++
            } else {
                right--
            }
        }
        return operation
    }
}
