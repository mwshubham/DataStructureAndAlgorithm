package leetcode.problems.category.dynamicprogramming.medium

/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
class PartitionEqualSubsetSum {
    companion object {
        /**
         * Using 1D - DP
         * Runtime: 196 ms, faster than 88.00% of Kotlin online submissions for Partition Equal Subset Sum.
         * Memory Usage: 35.7 MB, less than 90.00% of Kotlin online submissions for Partition Equal Subset Sum.
         */
        fun canPartition(nums: IntArray): Boolean {
            val sum = nums.sum()
            if (sum % 2 != 0) return false
            val target = sum / 2
            val dp = BooleanArray(target + 1)
            dp[0] = true

            for (num in nums) {
                for (i in target downTo num) {
                    dp[i] = dp[i] || dp[i - num]
                }
                if (dp[target]) return true
            }
            return dp.last()
        }

        /**
         * Using 2D DP
         * Runtime: 232 ms, faster than 72.00% of Kotlin online submissions for Partition Equal Subset Sum.
         * Memory Usage: 38.1 MB, less than 60.00% of Kotlin online submissions for Partition Equal Subset Sum.
         */
        fun canPartitionUsing2DimensionalDP(nums: IntArray): Boolean {
            val sum = nums.sum()
            if (sum % 2 != 0) return false
            val target = sum / 2
            val dp = Array(nums.size + 1) { BooleanArray(target + 1) { false } }
            for (i in 0..nums.size) {
                dp[i][0] = true
            }


            for (i in 1..nums.size) {
                for (j in 1..target) {
                    if (j >= nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]
                    } else {
                        dp[i][j] = dp[i - 1][j]
                    }
                }
            }
            return dp.last().last()
        }
    }

    fun canPartition2(nums: IntArray): Boolean {
        val sum = nums.sum()
        val target = sum / 2
        if (sum % 2 != 0) return false
        val memo = Array(nums.size) { arrayOfNulls<Boolean>(target + 1) }
        return dfs(0, target, nums, memo)
    }

    fun dfs(index: Int, target: Int, nums: IntArray, memo: Array<Array<Boolean?>>): Boolean {
        if (target == 0) return true

        if (target < 0) return false
        if (index > nums.lastIndex) return false

        if (memo[index][target] != null) return memo[index][target]!!

        val result = dfs(index + 1, target, nums, memo) || dfs(index + 1, target - nums[index], nums, memo)
        memo[index][target] = result

        return result
    }
}