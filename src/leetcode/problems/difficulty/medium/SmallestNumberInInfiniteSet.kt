package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.PriorityQueue

/**
 * 2336. Smallest Number in Infinite Set
 * https://leetcode.com/problems/smallest-number-in-infinite-set/description/?envType=study-plan-v2&envId=leetcode-75
 */
class SmallestNumberInInfiniteSet {

    private val minHeap = PriorityQueue<Int>()
    private var current = 1
    private val addedBackSet = HashSet<Int>()

    fun popSmallest(): Int {
        if (minHeap.isNotEmpty()) {
            val smallest = minHeap.poll()
            addedBackSet.remove(smallest)
            return smallest
        }
        return current++
    }

    fun addBack(num: Int) {
        if (num < current && !addedBackSet.contains(num)) {
            minHeap.add(num)
            addedBackSet.add(num)
        }
    }
}

fun main() {
    SmallestNumberInInfiniteSet().apply {
        popSmallest().println()
    }
}
