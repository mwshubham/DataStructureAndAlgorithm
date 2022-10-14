package leetcode.problems.difficulty.medium

/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 */
class HouseRobberII {

    companion object {
        /**
         * Runtime: 176 ms, faster than 89.82% of Kotlin online submissions for House Robber II.
         * Memory Usage: 35.9 MB, less than 44.44% of Kotlin online submissions for House Robber II.
         */
        fun rob(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            if (nums.size == 1) return nums.first()
            return Math.max(rob(nums, 0, nums.lastIndex - 1), rob(nums, 1, nums.lastIndex))
        }

        fun rob(nums: IntArray, start: Int, end: Int): Int {
            var ifRobbedPrevious = 0 // max money can get if rob current house
            var ifDidntRobPrevious = 0 // max money can get if not rob current house

            // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
            for (i in start..end) {
                val currRobbed = ifDidntRobPrevious + nums[i]
                val currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious)
                ifDidntRobPrevious = currNotRobbed
                ifRobbedPrevious = currRobbed
            }
            return Math.max(ifRobbedPrevious, ifDidntRobPrevious)
        }
    }
}