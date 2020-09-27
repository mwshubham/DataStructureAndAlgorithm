package leetcode.problems.stack.easy

import java.util.*

/**
 * Runtime: 160 ms, faster than 80.00% of Kotlin online submissions for Implement Queue using Stacks.
 * Memory Usage: 34.7 MB, less than 8.00% of Kotlin online submissions for Implement Queue using Stacks.
 */
class QueueUsingStacks {

    /** Initialize your data structure here. */
    val stack = Stack<Int>()


    /** Push element x to the back of queue. */
    fun push(x: Int) {
        stack.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        return stack.removeAt(0)
    }

    /** Get the front element. */
    fun peek(): Int {
        return stack.firstElement()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return stack.isEmpty()
    }

}

/**
 * Runtime: 148 ms, faster than 100.00% of Kotlin online submissions for Implement Queue using Stacks.
 * Memory Usage: 34.7 MB, less than 20.00% of Kotlin online submissions for Implement Queue using Stacks.
 *
 * Runtime: 156 ms, faster than 84.00% of Kotlin online submissions for Implement Queue using Stacks.
 * Memory Usage: 34.8 MB, less than 8.00% of Kotlin online submissions for Implement Queue using ArrayDeque.
 */
class QueueUsingStacks2 {

    var input = Stack<Int>()
    var output = Stack<Int>()

    fun push(x: Int) {
        input.push(x)
    }

    fun pop(): Int {
        peek()
        return output.pop()
    }

    fun peek(): Int {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop())
            }
        }
        return output.peek()
    }

    fun empty(): Boolean {
        return input.isEmpty() && output.isEmpty()
    }

}



