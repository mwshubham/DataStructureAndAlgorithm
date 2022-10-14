package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 */
class HouseRobber {

    companion object {
        /**
         * Runtime: 132 ms, faster than 91.92% of Kotlin online submissions for House Robber.
         * Memory Usage: 33.5 MB, less than 67.68% of Kotlin online submissions for House Robber.
         */
        fun rob(nums: IntArray): Int {
            var ifRobbedPrevious = 0 // max money can get if rob current house
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

        /**
         * Runtime: 211 ms, faster than 73.27% of Kotlin online submissions for House Robber.
         * Memory Usage: 36.1 MB, less than 13.21% of Kotlin online submissions for House Robber.
         */
        fun robDp(nums: IntArray): Int {
            val dp = IntArray(nums.size) { -1 }
            return solve(nums, dp, nums.lastIndex)
        }

        private fun solve(nums: IntArray, dp: IntArray, index: Int): Int {
            if (index < 0) return 0
            if (dp[index] != -1) return dp[index]

            dp[index] = Math.max(
                solve(nums, dp, index - 1), solve(nums, dp, index - 2) + nums[index]
            )
//            println("dp: ${dp.asList()}")
            return dp[index]
        }
    }
}

// TLE
// [114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240]
fun main() {
    HouseRobber.rob(intArrayOf(1, 2, 3, 1)).println()
    HouseRobber.robDp(intArrayOf(1, 2, 3, 1)).println()
    // 4
}