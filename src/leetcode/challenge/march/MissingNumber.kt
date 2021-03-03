package leetcode.challenge.march

/**
 * https://leetcode.com/submissions/detail/463118296/?from=explore&item_id=3659
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3659/
 *
 * https://leetcode.com/problems/missing-number/
 */
object MissingNumber {

    /**
     * Runtime: 208 ms, faster than 85.89% of Kotlin online submissions for Missing Number.
     * Memory Usage: 37 MB, less than 85.28% of Kotlin online submissions for Missing Number.
     */
    fun missingNumber(nums: IntArray): Int {
        var sum = nums.size
        for (i in nums.indices)
            sum += i - nums[i]
        return sum
    }

}