package leetcode.problems.linkedlist.medium

import datastructure.ListNode

private val Int.isEven: Boolean
    get() {
        return this % 2 == 0
    }


// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/
// https://leetcode.com/submissions/detail/340110891/?from=/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/
class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        var evenHeadNode: ListNode? = null
        var evenEndNode: ListNode? = null

        var oddHeadNode: ListNode? = null
        var oddEndNode: ListNode? = null

        var newHead: ListNode? = head ?: return null

        var count = 1

        while (newHead != null) {
            if (count.isEven) {
                if (evenHeadNode == null) {
                    evenHeadNode = newHead
                    evenEndNode = newHead
                } else {
                    evenEndNode!!.next = newHead
                    evenEndNode = evenEndNode.next
                }
                newHead = newHead.next
                count++
                evenEndNode!!.next = null
            } else {
                if (oddHeadNode == null) {
                    oddHeadNode = newHead
                    oddEndNode = newHead
                } else {
                    oddEndNode!!.next = newHead
                    oddEndNode = oddEndNode.next
                }
                newHead = newHead.next
                count++
                oddEndNode!!.next = null
            }
        }
        if (oddHeadNode == null) {
            return evenHeadNode
        } else {
            oddEndNode!!.next = evenHeadNode
        }
        return oddHeadNode
    }

// sample 156 ms submission
//    fun oddEvenList(head: ListNode?): ListNode? {
//        if (head?.next?.next == null) return head
//
//        var a = head
//        var b = a.next
//
//        var c = head.next
//        var currentOdd = c.next
//        var d = c.next.next
//
//        while (currentOdd != null) {
//            // 1) Move currentOdd between A & B
//            a?.next = currentOdd
//            currentOdd.next = b
//
//            // 2) Close up C & D
//            c.next = d
//
//            // 3) Move pointers (if necessary)
//            a = a?.next
//            c = c?.next
//            d = d?.next?.next
//            currentOdd = c?.next
//        }
//
//        return head
//    }
}

fun main() {
    val listNode = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    val instance = OddEvenLinkedList()
    instance.oddEvenList(listNode)
}