package leetcode.problems.linkedlist.easy

import datastructure.ListNode


class MiddleOfLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        var node = head
        val list = mutableListOf<ListNode>()
        while (node != null) {
            list.add(node)
            node = node.next
        }
        return list[list.size / 2]
    }

    /**
     * Runtime: 124 ms, faster than 90.28% of Kotlin online submissions for Middle of the Linked List.
     * Memory Usage: 33.4 MB, less than 19.44% of Kotlin online submissions for Middle of the Linked List.
     */
    fun middleNodeUsingSlowAndFastPointer(head: ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }
        return slow
    }
}