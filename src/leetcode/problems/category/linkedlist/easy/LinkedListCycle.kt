package leetcode.problems.category.linkedlist.easy

import datastructure.ListNode

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 */
class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        head ?: return false
        var slow = head
        var fast = head
        while (slow?.next != null && fast?.next?.next != null){
            slow = slow.next
            fast = fast.next?.next
            if (slow == fast) return true
        }
        return false
    }
}