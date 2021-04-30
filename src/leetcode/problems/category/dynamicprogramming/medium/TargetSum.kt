package leetcode.problems.category.dynamicprogramming.medium

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/
 */
//[1,1,1,1,1]
//3
//[1]
//1
//[0,0,0,0,0,0,0,0,1]
//1
class TargetSum {
    companion object {
        /**
         * Runtime: 148 ms, faster than 100.00% of Kotlin online submissions for Target Sum.
         * Memory Usage: 35.6 MB, less than 47.62% of Kotlin online submissions for Target Sum.
         */
        fun findTargetSumWays(nums: IntArray, target: Int): Int {
            val sum = nums.sum()
            if (target > sum || (target + sum) % 2 != 0) return 0
            val newTarget = (target + sum) / 2
            val dp = IntArray(newTarget + 1) { 0 }
            dp[0] = 1
            for (num in nums) {
                for (i in newTarget downTo 0) {
                    if (i >= num) {
                        dp[i] += dp[i - num]
                    }
                }
            }
            return dp.last()
        }
    }
}