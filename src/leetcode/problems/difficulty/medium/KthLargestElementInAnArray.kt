package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.PriorityQueue

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=leetcode-75
 */
class KthLargestElementInAnArray {

    // Using Max Heap
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>(reverseOrder())
        nums.forEach { queue.add(it) }
        var output = 0
        repeat(k) {
            output = queue.poll()
        }
        return output
    }

    // Min Heap
    fun findKthLargest2(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>()

        for (num in nums) {
            heap.add(num)

            if (heap.size > k) {
                heap.poll()
            }
        }

        return heap.peek()
    }
}

fun main() {
    KthLargestElementInAnArray().apply {
        findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2).println()
//        findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4).println()
    }
}
