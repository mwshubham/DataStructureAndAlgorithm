package leetcode.problems.category.stack.easy

import java.util.*

/**
 * https://leetcode.com/problems/min-stack/
 * 155. Min Stack
 * Runtime: 240 ms, faster than 69.00% of Kotlin online submissions for Min Stack.
 * Memory Usage: 39.6 MB, less than 76.50% of Kotlin online submissions for Min Stack.
 */
class MinStack() {

    val stack = Stack<Int>()
    val pq = PriorityQueue<Int>()


    fun push(`val`: Int) {
        stack.add(`val`)
        pq.add(`val`)
    }

    fun pop() {
        stack.pop().apply {
            pq.remove(this)
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return pq.peek()
    }

}