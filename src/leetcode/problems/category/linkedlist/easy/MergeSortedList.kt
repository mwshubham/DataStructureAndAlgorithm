package leetcode.problems.category.linkedlist.easy

import datastructure.ListNode

// https://leetcode.com/problems/merge-two-sorted-lists/
class MergeSortedList {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var list1 = l1
        var list2 = l2
        var mergedList: ListNode?

        if (list1    == null && list2 == null) {
            return null
        }
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }

        when {
            list1.`val` <= list2.`val` -> {
                mergedList = list1
                list1 = list1.next
            }
            else -> {
                mergedList = list2
                list2 = list2.next
            }
        }
        val mergedHead = mergedList

        while (list1 != null && list2 != null) {
            if (list1.`val` <= list2.`val`) {
                mergedList?.next = list1
                mergedList = mergedList?.next
                list1 = list1.next
            } else if (list1.`val` > list2.`val`) {
                mergedList?.next = list2
                mergedList = mergedList?.next
                list2 = list2.next
            }
        }
        while (list1 != null) {
            mergedList?.next = list1
            mergedList = mergedList?.next
            list1 = list1.next
        }

        while (list2 != null) {
            mergedList?.next = list2
            mergedList = mergedList?.next
            list2 = list2.next
        }
        return mergedHead
    }
}