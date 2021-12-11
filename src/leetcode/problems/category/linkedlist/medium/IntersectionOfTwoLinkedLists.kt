package leetcode.problems.category.linkedlist.medium

import datastructure.ListNode

/**
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/
 */
class IntersectionOfTwoLinkedLists {

    /**
     * Runtime: 156 ms, faster than 91.03% of Kotlin online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 38.9 MB, less than 41.67% of Kotlin online submissions for Intersection of Two Linked Lists.
     */
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) return null

        var tempA = headA
        var tempB = headB

        while (tempA != tempB) {
            tempA = if (tempA == null) headB else tempA.next
            tempB = if (tempB == null) headA else tempB.next
        }

        return tempA
    }

}

fun main() {
    val intersection = ListNode(
        8
    ).apply {
        next = ListNode(
            4
        ).apply {
            next = ListNode(
                5
            )
        }
    }
    val listA = ListNode(
        4
    ).apply {
        next = ListNode(
            1
        ).apply {
            next = intersection
        }
    }

    val listB = ListNode(
        5
    ).apply {
        next = ListNode(
            6
        ).apply {
            next = ListNode(
                7
            ).apply {
                next = intersection
            }
        }
    }

    IntersectionOfTwoLinkedLists().getIntersectionNode(
        listA,
        listB
    )
}

fun IntArray.toListNode(): ListNode? {
    if (isEmpty()) return null
    val listNode = ListNode(get(0)).apply {
        this.next = this@toListNode.copyOfRange(1, this@toListNode.size).toListNode()
    }
    return listNode
}