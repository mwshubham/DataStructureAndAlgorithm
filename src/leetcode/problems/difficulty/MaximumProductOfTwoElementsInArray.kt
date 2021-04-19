package leetcode.problems.difficulty

/**
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 */
class MaximumProductOfTwoElementsInArray {

    /**
     *  Runtime: 156 ms, faster than 100.00% of Kotlin online submissions for Maximum Product of Two Elements in an Array.
     *  Memory Usage: 35 MB, less than 7.69% of Kotlin online submissions for Maximum Product of Two Elements in an Array.
     */
    fun maxProduct(nums: IntArray): Int {
        var max1 = 0
        var max2 = 0
        for (i in nums.indices) {
            if (nums[i] >= max1) {
                max2 = max1
                max1 = nums[i]
            } else if (nums[i] >= max2) {
                max2 = nums[i]
            }
        }
        return --max1 * --max2
    }
}