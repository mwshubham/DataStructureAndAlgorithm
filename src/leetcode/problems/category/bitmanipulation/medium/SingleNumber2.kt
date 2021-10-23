package leetcode.problems.category.bitmanipulation.medium

/**
 * 137. Single Number II
 * https://leetcode.com/problems/single-number-ii/
 */
class SingleNumber2 {
    fun singleNumber(nums: IntArray): Int {
        var ones = 0
        var twos = 0
        for (i in nums.indices) {
            ones = ones xor nums[i] and twos.inv()
            twos = twos xor nums[i] and ones.inv()
        }
        return ones
    }
}