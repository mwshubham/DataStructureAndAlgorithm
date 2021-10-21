package leetcode.problems.category.dynamicprogramming.medium

/**
 * 368. Largest Divisible Subset
 * https://leetcode.com/problems/largest-divisible-subset/
 */
class LargestDivisibleSubset {
    companion object {
        fun largestDivisibleSubset(nums: IntArray): List<Int> {
            val res = ArrayList<Int>()
            if (nums.size == 1) return res.apply {
                add(nums[0])
            }

            val dp = IntArray(nums.size) { 1 }
            val pre = IntArray(nums.size) { -1 }

            var index = -1
            var max = 0

            nums.sort()

            for (i in 1..nums.lastIndex) {
                for (j in 0 until i) {
                    if (nums[i] % nums[j] == 0 && (1 + dp[j]) > dp[i]) {
                        dp[i] = 1 + dp[j]
                        pre[i] = j
                    }
                }

                if (dp[i] > max) {
                    max = dp[i]
                    index = i
                }
            }

            while (index != -1) {
                res.add(nums[index])
                index = pre[index]
            }

            return res
        }
    }
}