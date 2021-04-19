package leetcode.problems.category.linkedlist.easy

import datastructure.ListNode

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
class BinaryToInteger {
    fun getDecimalValue(head: ListNode?): Int {
        var result = 0
        var node: ListNode? = head
        while (node != null) {
            result = result shl 1
            result = result or node.`val`
            node = node.next
        }
        return result
    }
}

