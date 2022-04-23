package leetcode.problems.difficulty.hard

import kotlin1.println

/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/
 */
//[1,2,0]
//[3,4,-1,1]
//[7,8,9,11,12]
//[3,4,-1,1]
class FirstMissingPositive {
    /**
     * Runtime: 970 ms, faster than 66.48% of Kotlin online submissions for First Missing Positive.
     * Memory Usage: 119.8 MB, less than 65.91% of Kotlin online submissions for First Missing Positive.
     */
    fun firstMissingPositive(nums: IntArray): Int {
        var i = 0
        while (i <= nums.lastIndex) {
            if (nums[i] in 1..nums.size && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1)
            } else {
                i++
            }
        }
        nums.println()
        for (i in nums.indices) {
            if (nums[i] != i + 1) return i + 1
        }
        return nums.size + 1
    }

    private fun swap(A: IntArray, i: Int, j: Int) {
        val temp = A[i]
        A[i] = A[j]
        A[j] = temp
    }
}

fun main() {
    FirstMissingPositive().firstMissingPositive(intArrayOf(1, 2, 3)).println()
    FirstMissingPositive().firstMissingPositive(intArrayOf(3, 4, -1, 1)).println()
    FirstMissingPositive().firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)).println()
    FirstMissingPositive().firstMissingPositive(intArrayOf(1, 1)).println()
}