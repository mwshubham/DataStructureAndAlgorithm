package leetcode.problems.difficulty

import java.util.*

/**
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 */
class CreateTargetArrayInGivenOrder {
    /**
     * Runtime: 168 ms, faster than 79.10% of Kotlin online submissions for Create Target Array in the Given Order.
     * Memory Usage: 35 MB, less than 58.21% of Kotlin online submissions for Create Target Array in the Given Order.
     */
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val list = ArrayList<Int>(nums.size)
        index.forEachIndexed { _index, value ->
            list.add(value, nums[_index])
        }
        return list.toIntArray()
    }
}