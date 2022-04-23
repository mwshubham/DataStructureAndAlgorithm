package leetcode.problems.difficulty.medium

import kotlin.math.max

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 * 1004. Max Consecutive Ones III
 */
class MaxConsecutiveOnesIII {

    /**
     * Runtime: 671 ms, faster than 15.66% of Kotlin online submissions for Max Consecutive Ones III.
     * Memory Usage: 69.3 MB, less than 51.81% of Kotlin online submissions for Max Consecutive Ones III.
     */
    fun longestOnes(nums: IntArray, k: Int): Int {
        var zeroCount = 0
        var start = 0
        var res = 0

        for (end in nums.indices) {
            if (nums[end] == 0) zeroCount++
            while (zeroCount > k) {
                if (nums[start] == 0) zeroCount--
                start++
            }
            res = max(res, end - start + 1)
        }

        return res
    }
}