package leetcode.problems.difficulty.medium

/**
 * https://leetcode.com/problems/product-of-array-except-self
 */
class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixArr = IntArray(nums.size) { 1 }
        val suffixArr = IntArray(nums.size) { 1 }
        nums.forEachIndexed { index, _ ->
            val suffixIndex = nums.lastIndex - index
            prefixArr[index] = prefixArr.getOrElse(index - 1) { 1 } * nums.getOrElse(index - 1) { 1 }
            suffixArr[suffixIndex] = suffixArr.getOrElse(suffixIndex + 1) { 1 } * nums.getOrElse(suffixIndex + 1) { 1 }
        }
        nums.forEachIndexed { index, _ ->
            nums[index] = prefixArr[index] * suffixArr[index]
        }
        return nums
    }
}