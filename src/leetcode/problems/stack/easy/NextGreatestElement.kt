package leetcode.problems.stack.easy

import java.util.*

/**
 * https://leetcode.com/problems/next-greater-element-i/
 */
class NextGreatestElement {
    /**
     * Runtime: 184 ms, faster than 82.35% of Kotlin online submissions for Next Greater Element I.\
     * Memory Usage: 35.6 MB, less than 35.29% of Kotlin online submissions for Next Greater Element I.
     */
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val map: MutableMap<Int, Int> = HashMap()
        val stack = Stack<Int>()
        for (num in nums2) {
            while (!stack.isEmpty() && stack.peek() < num) map[stack.pop()] = num
            stack.push(num)
        }
        nums1.forEachIndexed { index, value ->
            nums1[index] = map.getOrDefault(value, -1)
        }
        return nums1
    }
}