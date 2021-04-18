package leetcode.challenge.april

import datastructure.ListNode

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3712/
 */
class RemoveNthNodeFromEndOfList {
    companion object {

        /**
         * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3712/
         * Runtime: 164 ms, faster than 59.80% of Kotlin online submissions for Remove Nth Node From End of List.
         * Memory Usage: 34.9 MB, less than 88.94% of Kotlin online submissions for Remove Nth Node From End of List.
         */
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            val start = ListNode(0)
            var slow: ListNode? = start
            var fast: ListNode? = start

            start.next = head

            repeat(n + 1) {
                fast = fast?.next
            }
            while (fast != null) {
                slow = slow?.next
                fast = fast?.next
            }

            slow?.next = slow?.next?.next
            return start.next
        }
    }
}