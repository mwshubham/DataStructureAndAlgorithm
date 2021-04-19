package leetcode.problems.category.array.medium

/**
 * https://leetcode.com/problems/sort-colors/
 */
class SortColors {
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