package leetcode.problems.difficulty.medium

import datastructure.ListNode
import kotlin1.println

/**
 * 2130. Maximum Twin Sum of a Linked List
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 */
class MaximumTwinSumOfALinkedList {

    fun pairSum(head: ListNode?): Int {
        val queue = ArrayDeque<Int>()
        var node = head
        while (node != null) {
            queue.add(node.`val`)
            node = node.next
        }
        var max = 0
        while (queue.isNotEmpty()) {
            max = Math.max(max, queue.removeFirst() + queue.removeLast())
        }
        return max
    }

    // 1, 2, 3, 4, 5
    fun pairSum2(head: ListNode?): Int {
        var slow = head
        var fast = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        var prev: ListNode? = null
        var current = slow

        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }

        var first = head
        var second = prev

        var max = 0

        while (second != null) {
            max = maxOf(
                max,
                first!!.`val` + second.`val`
            )

            first = first.next
            second = second.next
        }
        return max
    }
}

fun main() {
    val head = ListNode(5).apply {
        next = ListNode(4).apply {
            next = ListNode(2).apply {
                next = ListNode(1)
            }
        }
    }
    MaximumTwinSumOfALinkedList().pairSum(head).println()
}
