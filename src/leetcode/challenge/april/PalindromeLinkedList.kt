package leetcode.challenge.april

import datastructure.ListNode

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3693/
 */
class PalindromeLinkedList {

    //    [1,2,2,1]
//    [1,2,3,2,1]
//    [1,2,3]
    companion object {
        /**
         * https://leetcode.com/submissions/detail/475385185/?from=explore&item_id=3693
         */
        fun isPalindromeUsingArrayList(head: ListNode?): Boolean {
            head ?: return true
            val list = ArrayList<Int>()
            var node = head
            while (node != null) {
                list.add(node.`val`)
                node = node.next
            }
            repeat(list.size / 2) {
                if (list[it] != list[list.lastIndex - it]) {
                    return false
                }
            }
            return true
        }

        /**
         * https://leetcode.com/submissions/detail/475394953/?from=explore&item_id=3693
         * Runtime: 524 ms, faster than 26.18% of Kotlin online submissions for Palindrome Linked List.
         * Memory Usage: 50.7 MB, less than 30.89% of Kotlin online submissions for Palindrome Linked List.
         */
        fun isPalindromeByReversingTheLinkedList(head: ListNode?): Boolean {
            head ?: return true
            var slow = head
            var fast = head

            while (fast?.next != null) {
                slow = slow?.next
                fast = fast.next?.next
            }
            // odd nodes: let right half smaller
            fast?.let {
                slow = slow?.next
            }
            slow = reverse(slow)
            fast = head
            while (slow != null) {
                if (slow?.`val` != fast?.`val`) {
                    return false
                }
                slow = slow?.next
                fast = fast?.next
            }
            return true
        }

        fun reverse(node: ListNode?): ListNode? {
            var curr = node
            var prev: ListNode? = null
            var next: ListNode?
            while (curr != null) {
                next = curr.next
                curr.next = prev
                prev = curr
                curr = next
            }
            return prev
        }
    }
}

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(2).apply {
                next = ListNode(1).apply {
                }
            }
        }
    }
    PalindromeLinkedList.isPalindromeByReversingTheLinkedList(head)
}

