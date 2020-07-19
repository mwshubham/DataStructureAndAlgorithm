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
}