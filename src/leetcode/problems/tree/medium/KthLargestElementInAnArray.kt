package leetcode.problems.tree.medium

import java.util.*

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
class KthLargestElementInAnArray {
    companion object {
        /**
         * Runtime: 216 ms, faster than 63.83% of Kotlin online submissions for Kth Largest Element in an Array.
         * Memory Usage: 36.1 MB, less than 81.21% of Kotlin online submissions for Kth Largest Element in an Array.
         */
        fun findKthLargest(nums: IntArray, k: Int): Int {
            val queue = PriorityQueue<Int>(reverseOrder())
            nums.forEach { queue.add(it) }
            var output = 0
            repeat(k) {
                output = queue.poll()
            }
            return output
        }
    }
}