package leetcode.problems.difficulty.medium

import kotlin.math.max

/**
 * 1004. Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/
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

    // [1,1,1,0,2,2,1,1,1,1,0], k = 2
    fun longestOnes2(nums: IntArray, k: Int): Int {
        if (nums.size <= k) return nums.size
        var ans = 0
        var flipsLeft = k
        var left = 0
        for (right in nums.indices) {
            if (nums[right] == 0) {
                if (flipsLeft > 0) {
                    nums[right] = 2
                    flipsLeft--
                } else {
                    if (k > 0) {
                        // Remove the oldest flipped zero
                        while (nums[left] != 2) {
                            left++
                        }
                        nums[right] = 2
                    } else {
                        while (nums[left] != 0) {
                            left++
                        }
                    }
                    left++
                }
            }
            ans = maxOf(ans, right - left + 1)
        }
        return ans
    }
}