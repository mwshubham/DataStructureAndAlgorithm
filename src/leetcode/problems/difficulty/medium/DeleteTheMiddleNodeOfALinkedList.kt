package leetcode.problems.difficulty.medium

import datastructure.ListNode
import kotlin1.println

/**
 * 2095. Delete the Middle Node of a Linked List
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 */
class DeleteTheMiddleNodeOfALinkedList {

    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) return null

        var slow: ListNode? = head
        var fast: ListNode? = head.next?.next

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        slow?.next = slow.next?.next
        return head
    }
}

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(4).apply {
                next = ListNode(7).apply {
                    next = ListNode(1).apply {
                        next = ListNode(2).apply {
                            next = ListNode(6)
                        }
                    }
                }
            }
        }
    }
    DeleteTheMiddleNodeOfALinkedList().deleteMiddle(head).println()
}
