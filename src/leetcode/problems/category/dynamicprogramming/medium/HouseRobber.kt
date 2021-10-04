package leetcode.problems.category.dynamicprogramming.medium

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 */
class HouseRobber {

    /**
     * Runtime: 132 ms, faster than 91.92% of Kotlin online submissions for House Robber.
     * Memory Usage: 33.5 MB, less than 67.68% of Kotlin online submissions for House Robber.
     */
    fun rob(nums: IntArray): Int {
        var ifRobbedPrevious = 0 // max monney can get if rob current house
        var ifDidntRobPrevious = 0 // max money can get if not rob current house

        // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
        for (i in nums.indices) {
            val currRobbed = ifDidntRobPrevious + nums[i]
            val currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious)
            ifDidntRobPrevious = currNotRobbed
            ifRobbedPrevious = currRobbed
        }
        return Math.max(ifRobbedPrevious, ifDidntRobPrevious)
    }
}