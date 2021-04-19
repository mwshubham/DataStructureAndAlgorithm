package leetcode.problems.dynamicprogramming.medium

import kotlin1.println

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3713/
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