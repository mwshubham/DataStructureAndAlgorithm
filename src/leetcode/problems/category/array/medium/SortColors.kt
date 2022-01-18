package leetcode.problems.category.array.medium

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/
 */
class SortColors {
    /**
     * Runtime: 176 ms, faster than 57.66% of Kotlin online submissions for Sort Colors.
     * Memory Usage: 36.5 MB, less than 11.68% of Kotlin online submissions for Sort Colors.
     */
    fun sortColors(nums: IntArray): Unit {
        var l = 0
        var m = 0
        var h = nums.lastIndex
        while (m <= h) {
            when (nums[m]) {
                0 -> {
                    val temp = nums[l]
                    nums[l] = nums[m]
                    nums[m] = temp
                    l++
                    m++
                }
                1 -> {
                    m++
                }
                2 -> {
                    val temp = nums[h]
                    nums[h] = nums[m]
                    nums[m] = temp
                    h--
                }
            }
        }
    }
}