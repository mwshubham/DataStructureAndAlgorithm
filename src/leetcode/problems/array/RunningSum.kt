package leetcode.problems.array

class Solution {
    fun runningSum(nums: IntArray): IntArray {
        (1..nums.lastIndex).forEach {
            nums[it] += nums[it - 1]
        }
        return nums
    }
}

private fun main() {
    val instance = Solution()
    println(instance.runningSum(intArrayOf(1, 2, 3, 4)).asList()) // [1,3,6,10]
    println(instance.runningSum(intArrayOf(1, 1, 1, 1)).asList()) // [1,2,3,4]
}