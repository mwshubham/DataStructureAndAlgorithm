package leetcode.problems.category.linkedlist.easy

import datastructure.ListNode

// 1,2,3,4,5
class ReverseList {
    fun reverseList(head: ListNode?): ListNode? {
        var node = head
        var prev: ListNode? = null
        while (node != null) {
            val next = node.next
            node.next = prev
            prev = node
            node = next
        }
        return prev
    }

    fun reverseList1(head: ListNode?): ListNode? {
        if (head == null) return null
        var node = head
        var prev: ListNode? = null
        while (node != null) {
            val next = node.next
            node.next = prev
            if (next == null) {
                return node
            }
            prev = node
            node = next
        }
        throw IllegalStateException("...")
    }
}
