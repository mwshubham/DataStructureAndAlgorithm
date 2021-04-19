package leetcode.problems.category.tree.easy

import java.util.*

/**
 * https://leetcode.com/problems/last-stone-weight/
 */
class LastStoneWeight {
    companion object {
        /**
         * Runtime: 152 ms, faster than 68.42% of Kotlin online submissions for Last Stone Weight.
         * Memory Usage: 33.8 MB, less than 65.79% of Kotlin online submissions for Last Stone Weight.
         */
        fun lastStoneWeight(stones: IntArray): Int {
            val heap = PriorityQueue<Int>(reverseOrder())
            stones.forEach { heap.add(it) }
            while (heap.isNotEmpty()) {
                if (heap.size == 1) {
                    return heap.poll()
                }
                val first = heap.poll()
                val second = heap.poll()
                (first - second)
                    .takeIf { it != 0 }
                    ?.let {
                        heap.add(it)
                    }

            }
            return 0
        }
    }
}

fun main() {
    LastStoneWeight.lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1))
}