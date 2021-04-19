package leetcode.problems.category.stack.easy

import java.util.*

/**
 * Runtime: 144 ms, faster than 95.00% of Kotlin online submissions for Implement Stack using Queues.
 * Memory Usage: 34.7 MB, less than 35.00% of Kotlin online submissions for Implement Stack using Queues.
 */
class StackUsingQueue() {

    var queue = ArrayDeque<Int>()

    fun push(x: Int) {
        queue.add(x)
        for (i in 1 until queue.size) queue.add(queue.remove())
    }

    fun pop(): Int {
        return queue.remove()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }


    /** Get the top element. */
    fun top(): Int {
        return queue.peek()
    }

}
