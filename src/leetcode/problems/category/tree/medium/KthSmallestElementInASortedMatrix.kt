package leetcode.problems.category.tree.medium

import java.util.*

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
class KthSmallestElementInASortedMatrix {
    /**
     * Runtime: 304 ms, faster than 57.73% of Kotlin online submissions for Kth Smallest Element in a Sorted Matrix.
     * Memory Usage: 45 MB, less than 68.04% of Kotlin online submissions for Kth Smallest Element in a Sorted Matrix.
     */
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val queue = PriorityQueue<Int>()
        matrix.forEach { it.forEach { queue.add(it) } }
        var output = 0
        repeat(k) {
            output = queue.poll()
        }
        return output
    }
}