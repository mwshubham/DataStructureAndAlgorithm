package leetcode.challenge.may21

/**
 * 1480. Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3730/
 * https://leetcode.com/submissions/detail/488249560/?from=explore&item_id=3730
 */
class RunningSumOf1dArray {
    companion object {
        fun runningSum(nums: IntArray): IntArray {
            nums.forEachIndexed { index, num ->
                if (index > 0) {
                    nums[index] = num + nums[index - 1]
                }
            }
            return nums
        }
    }
}