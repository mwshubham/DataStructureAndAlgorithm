package leetcode.problems.difficulty.hard

import datastructure.ListNode
import java.util.*

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
class MergeKSortedLists {
    companion object {
        /**
         * Runtime: 216 ms, faster than 64.65% of Kotlin online submissions for Merge k Sorted Lists.
         * Memory Usage: 41.8 MB, less than 38.14% of Kotlin online submissions for Merge k Sorted Lists.
         */
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.isNullOrEmpty()) return null
            val pq = PriorityQueue<ListNode>(lists.size) { o1, o2 ->
                o1.`val` - o2.`val`
            }

            val dummy = ListNode(0)
            var tail: ListNode? = dummy

            for (item in lists) {
                item?.let {
                    pq.add(it)
                }
            }
            while (pq.isNotEmpty()) {
                tail?.next = pq.poll()
                tail = tail?.next

                tail?.next?.let {
                    pq.add(tail.next)
                }
            }

            return dummy.next
        }
    }
}