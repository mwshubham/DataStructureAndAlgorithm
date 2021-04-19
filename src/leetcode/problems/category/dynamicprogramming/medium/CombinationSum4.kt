package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3713/
 * https://leetcode.com/problems/combination-sum-iv/
 */
class CombinationSum4 {

    companion object {
        //        var result = 0
        lateinit var dp: IntArray

        /**
         * https://leetcode.com/submissions/detail/482542182/?from=explore&item_id=3713
         *
         * Runtime: 156 ms, faster than 29.41% of Kotlin online submissions for Combination Sum IV.
         * Memory Usage: 35.8 MB, less than 11.76% of Kotlin online submissions for Combination Sum IV.
         */
        fun combinationSum4(nums: IntArray, target: Int): Int {
            dp = IntArray(target + 1) { 0 }
            // for target sum 0, we have to select none element thus 1
            dp[0] = 1
            for (i in 1..target) {
                for (j in nums.indices) {
                    if (i - nums[j] >= 0) {
                        dp[i] += dp[i - nums[j]]
                    }
                }
            }
            return dp.last()
        }

        /**
         * Runtime: 152 ms, faster than 29.41% of Kotlin online submissions for Combination Sum IV.
         * Memory Usage: 33.2 MB, less than 88.24% of Kotlin online submissions for Combination Sum IV.
         */
        fun combinationSum4AnotherDP(nums: IntArray, target: Int): Int {
            return combinationSum4AnotherDP(nums, target, IntArray(target + 1) { -1 })
        }

        fun combinationSum4AnotherDP(nums: IntArray, target: Int, dp: IntArray): Int {
            if (target == 0) return 1
            if (target < 0) return 0
            if (dp[target] != -1) return dp[target]
            var count = 0
            for (num in nums) {
                if (target >= num) {
                    count += combinationSum4AnotherDP(nums, target - num, dp)
                }
                dp[target] = count
            }
            return dp[target]
        }

        // Recusive Solution
//        private fun getSubsetSum(nums: IntArray, target: Int) {
//            if (target == 0) result++
//            for (num in nums) {
//                if (target >= num) {
//                    getSubsetSum(nums, target - num)
//                }
//            }
//        }
    }
}

fun main() {
    CombinationSum4.combinationSum4(intArrayOf(1, 2, 3), 4).println()
}