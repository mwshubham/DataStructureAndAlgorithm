package leetcode.problems.category.linkedlist.easy

import datastructure.ListNode


// 1 -> 2 -> 3 -> 51
// 41 -> 42 -> 43


// 2
// 1

// https://leetcode.com/problems/merge-two-sorted-lists/
class MergeSortedList {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        val head = if (list1.`val` <= list2.`val`) {
            list1
        } else {
            list2
        }
        var node1 = list1
        var node2 = list2
        while (node1 != null && node2 != null) {
            while (node1 != null && node1.`val` <= node2.`val`) {
                node1 = node1.next
            }
            if (node1?.next == null) {
                node1?.next = node2
                return head
            } else {
                val next = node1.next
                node1.next = node2
                node1 = next
            }
            while (node2?.next != null && node2.next!!.`val` <= node1!!.`val`) {
                node2 = node2.next
            }
            if (node2?.next == null) {
                node2?.next = node1
                return head
            } else {
                val next = node2.next
                node2.next = node1
                node2 = next
            }
        }
        return head
    }
}