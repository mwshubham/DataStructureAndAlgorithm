package leetcode.problems.category.linkedlist.medium

import datastructure.ListNode
import java.util.*


// https://leetcode.com/problems/add-two-numbers-ii/
class Solution {
    @Suppress("NAME_SHADOWING")
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1 = l1
        var l2 = l2

        val l1Stack = Stack<Int>()

        while (l1 != null) {
            l1Stack.push(l1.`val`)
            l1 = l1.next
        }

        val l2Stack = Stack<Int>()

        while (l2 != null) {
            l2Stack.push(l2.`val`)
            l2 = l2.next
        }

        var carry = 0
        var dummy: ListNode? = null
        while (l1Stack.isNotEmpty() || l2Stack.isNotEmpty() || carry != 0) {
            val first = if (l1Stack.isEmpty()) 0 else l1Stack.pop()
            val second = if (l2Stack.isEmpty()) 0 else l2Stack.pop()
            val total = first + second + carry

            val tempNode = ListNode(total % 10)
            tempNode.next = dummy
            dummy = tempNode
            carry = total / 10
        }

        return dummy
    }
}