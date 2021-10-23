package leetcode.problems.category.array.hard

// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3401/
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
// https://leetcode.com/submissions/detail/371730027/?from=/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3401/
/**
 * 154. Find Minimum in Rotated Sorted Array II
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
class MinimumInSortedArray2 {
    /**
     * Runtime: 188 ms, faster than 81.58% of Kotlin online submissions for Find Minimum in Rotated Sorted Array II.
     * Memory Usage: 38.8 MB, less than 18.42% of Kotlin online submissions for Find Minimum in Rotated Sorted Array II.
     */
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.lastIndex
        var mid: Int

        while (l < r) {
            mid = l + (r - l) / 2
            when {
                nums[mid] > nums[r] -> {
                    l = mid + 1
                }
                nums[mid] < nums[r] -> {
                    r = mid
                }
                else -> { // when nums[mid] and nums[r] are same
                    r--
                }
            }
        }
        return nums[l]
    }

}