package leetcode.problems.category.array.easy

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
class SmallestNumberThanCurrent {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val bucket = IntArray(102)
        for (element in nums) bucket[element + 1]++
        for (i in 1..101) bucket[i] += bucket[i - 1]
        for (i in nums.indices) nums[i] = bucket[nums[i]]
        return nums
    }
}