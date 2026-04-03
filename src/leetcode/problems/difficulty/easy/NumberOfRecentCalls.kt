package leetcode.problems.difficulty.easy

import java.util.LinkedList

/**
 * 933. Number Of Recent Calls
 */
class RecentCounter {

    val queue = LinkedList<Int>()

    fun ping(t: Int): Int {
        queue.add(t)
        while (queue.peek() < t - 3000) queue.remove()
        return queue.size
    }
}