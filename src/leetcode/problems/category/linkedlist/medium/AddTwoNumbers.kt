package leetcode.problems.category.linkedlist.medium

import datastructure.ListNode

/**
 * 2. Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/
 * https://leetcode.com/submissions/detail/600183669/?from=explore&item_id=783
 */
//[2,4,3]
//[5,6,6]
//[2,4,3,9,9]
//[5,6,4]
//[2,4,3]
//[5,6,4,9,9]
//[9,9,9,9,9,9,9]
//[9,9,9,9]
//[9,9,9,9]
//[9,9,9,9,9,9,9]
class AddTwoNumbers {
    /**
     * Runtime: 216 ms, faster than 67.39% of Kotlin online submissions for Add Two Numbers.
     * Memory Usage: 41.4 MB, less than 74.13% of Kotlin online submissions for Add Two Numbers.
     */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0
        var l1 = l1
        var l2 = l2

        if (l1 == null) return l2
        if (l2 == null) return l1

        val headL2 = l2
        var prevL2: ListNode? = null

        while (l1 != null && l2 != null) {
            val sum = l1.`val` + l2.`val` + carry
            carry = if (sum >= 10) 1 else 0
            l2.`val` = sum % 10

            l1 = l1.next
            prevL2 = l2
            l2 = l2.next
        }

        if (l1 == null && l2 == null) {
            // If there is a carry left
            if (carry != 0) {
                prevL2?.next = ListNode(carry)
            }
            return headL2
        }

        if (l1 == null) {
            // l1 is ended while l2 is not
            if (l2 != null) {
                while (carry != 0) {
                    if (l2 == null) {
                        prevL2?.next = ListNode(carry)
                        break
                    }
                    val sum = l2.`val` + carry
                    carry = if (sum >= 10) 1 else 0
                    l2.`val` = sum % 10
                    prevL2 = l2
                    l2 = l2.next
                }
            }
        } else {
            // l1 is not ended while l2 is
            prevL2?.next = l1
            while (carry != 0) {
                if (l1 == null) {
                    prevL2?.next = ListNode(carry)
                    break
                }
                val sum = l1.`val` + carry
                carry = if (sum >= 10) 1 else 0
                l1.`val` = sum % 10
                prevL2 = l1
                l1 = l1.next
            }
        }

        return headL2
    }
}