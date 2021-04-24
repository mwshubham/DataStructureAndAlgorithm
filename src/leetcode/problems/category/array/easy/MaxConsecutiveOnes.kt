package leetcode.problems.category.array.easy

/**
 * 485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
 *
 * https://leetcode.com/submissions/detail/484462668/?from=explore&item_id=3238
 */
class MaxConsecutiveOnes {
    companion object {
        /**
         * Runtime: 212 ms, faster than 99.08% of Kotlin online submissions for Max Consecutive Ones.
         * Memory Usage: 37.2 MB, less than 90.37% of Kotlin online submissions for Max Consecutive Ones.
         */
        fun findMaxConsecutiveOnes(nums: IntArray): Int {
            var max = 0
            var sum = 0
            for (i in nums.indices) {
                sum += nums[i]
                if (nums[i] == 0) // reset sum to zero when encounters zeros
                    sum = 0 else  // keep update max
                    max = Math.max(max, sum)
            }
            return max
        }
    }
}