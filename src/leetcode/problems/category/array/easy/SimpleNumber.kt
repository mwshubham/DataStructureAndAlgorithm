package leetcode.problems.category.array.easy

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 */
class SimpleNumber {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            result = result xor nums[i]
        }
        return result
    }
}