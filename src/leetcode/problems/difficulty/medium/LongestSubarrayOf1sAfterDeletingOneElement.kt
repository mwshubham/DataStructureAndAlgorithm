package leetcode.problems.difficulty.medium

import kotlin1.println
import kotlin.math.max

/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
class LongestSubarrayOf1sAfterDeletingOneElement {

    // [0,1,1,1,0,1,1,0,1]
    // [1,1,0,1]
    fun longestSubarray(nums: IntArray): Int {
        var start = 0
        while (nums[start] == 0) {
            start++
            if (start == nums.size) return 0
        }
        var res = 0
        var zeroIndex = -1
        var left = start
        for (right in start until nums.size) {
            if (nums[right] == 1) {
                res = max(res, right - left + if (zeroIndex == -1) 1 else 0)
            } else if (zeroIndex == -1) {
                zeroIndex = right
            } else {
                left = zeroIndex + 1
                zeroIndex = right
            }
        }
        return if (zeroIndex == -1 && start == 0) res - 1 else res
    }

    fun longestSubarray2(nums: IntArray): Int {
        var left = 0
        var zeros = 0
        var ans = 0

        for (right in nums.indices) {
            if (nums[right] == 0) zeros++

            while (zeros > 1) {
                if (nums[left] == 0) zeros--
                left++
            }

            ans = maxOf(ans, right - left)
        }

        return ans


    }
}

fun main() {
    LongestSubarrayOf1sAfterDeletingOneElement().apply {
//        longestSubarray(intArrayOf(1, 1, 0, 1)).println()
//        longestSubarray(intArrayOf(1, 1, 1)).println()
        longestSubarray(intArrayOf(0,0,1,1)).println()
    }
}
