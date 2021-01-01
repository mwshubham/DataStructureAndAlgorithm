package leetcode.problems.bitmanipulation.medium

/**
 * https://leetcode.com/problems/single-number/
 */
class SingleNumber1 {
    /**
     * Runtime: 208 ms, faster than 82.47% of Kotlin online submissions for Single Number.
     * Memory Usage: 37.7 MB, less than 50.60% of Kotlin online submissions for Single Number.
     */
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            result = result xor nums[i]
        }
        return result
    }
}