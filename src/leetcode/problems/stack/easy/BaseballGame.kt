package leetcode.problems.stack.easy

import jdk.vm.ci.code.Location.stack
import java.util.*


class BaseballGame {
    /**
     * Using Stack
     * Runtime: 180 ms, faster than 66.67% of Kotlin online submissions for Baseball Game.
     * Memory Usage: 34.5 MB, less than 33.33% of Kotlin online submissions for Baseball Game.
     */
    fun calPointsUsingStack(ops: Array<String>): Int {
        val stack = Stack<Int>()
        ops.forEach {
            when (it) {
                "+" -> {
                    val one = stack.pop()
                    val two = stack.pop()
                    stack.push(two)
                    stack.push(one)
                    stack.push(one + two)
                }
                "C" -> stack.pop()
                "D" -> stack.push(stack.peek() * 2)
                else -> stack.push(it.toInt())
            }
        }
        return stack.sum()
    }

    /**
     * Runtime: 180 ms, faster than 66.67% of Kotlin online submissions for Baseball Game.
     * Memory Usage: 34.3 MB, less than 50.00% of Kotlin online submissions for Baseball Game.
     */
    fun calPointsUsingLinkedList(ops: Array<String>): Int {
        val list = LinkedList<Int>()
        var sum = 0
        ops.forEach {
            when (it) {
                "+" -> {
                    list.add(list.peekLast() + list[list.lastIndex - 1])
                    sum += list.peekLast()
                }
                "C" -> {
                    sum -= list.removeLast()
                }
                "D" -> {
                    list.add(list.peekLast() * 2)
                    sum += list.peekLast();
                }
                else -> {
                    list.add(it.toInt())
                    sum += list.peekLast()
                }
            }
        }
        return sum
    }

    /**
     * Runtime: 156 ms, faster than 100.00% of Kotlin online submissions for Baseball Game.
     * Memory Usage: 34.1 MB, less than 83.33% of Kotlin online submissions for Baseball Game.
     */
    fun calPointsUsingDeque(ops: Array<String>): Int {
        val list = ArrayDeque<Int>()
        var sum = 0
        ops.forEach {
            when (it) {
                "+" -> {
                    val top = list.pop()
                    val newTop = list.peek()
                    val value = top + newTop
                    list.addFirst(top)
                    list.addFirst(value)
                    sum += value
                }
                "C" -> {
                    sum -= list.removeFirst()
                }
                "D" -> {
                    list.addFirst(list.peekFirst() * 2)
                    sum += list.peekFirst();
                }
                else -> {
                    list.addFirst(it.toInt())
                    sum += list.peekFirst()
                }
            }
        }
        return sum
    }
}