package leetcode.challenge.april

import datastructure.ListNode


/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3707/
 * https://leetcode.com/problems/partition-list/
 */
//[1,4,3,2,5,2]
//1
//[1,4,3,2,5,2]
//2
//[1,4,3,2,5,2]
//3
//[1,4,3,2,5,2]
//4
//[1,4,3,2,5,2]
//5
//[1,4,3,2,5,2]
//0
//[1,4,3,2,5,2]
//6
//[1,4,3,2,5,2]
//-200
//[1,4,3,2,5,2]
//200
//[]
//0
//[4,4,3,2,5,2]
//1
//[4,4,3,2,5,2]
//2
//[4,4,3,2,5,2]
//3

class PartitionList {

    /**
     * https://leetcode.com/submissions/detail/480518798/?from=explore&item_id=3707
     * Runtime: 164 ms, faster than 46.88% of Kotlin online submissions for Partition List.
     * Memory Usage: 35 MB, less than 40.63% of Kotlin online submissions for Partition List.
     */
    companion object {
        fun partition(head: ListNode?, x: Int): ListNode? {
            var current = head

            var start: ListNode? = null
            var startIter: ListNode? = null

            var greaterOrEqual: ListNode? = null
            var greaterOrEqualIter: ListNode? = null

            while (current != null) {
                if (current.`val` < x) {
                    if (start == null) {
                        start = current
                        startIter = current
                    } else {
                        startIter?.next = current
                        startIter = current
                    }
                } else {
                    if (greaterOrEqual == null) {
                        greaterOrEqual = current
                        greaterOrEqualIter = current
                    } else {
                        greaterOrEqualIter?.next = current
                        greaterOrEqualIter = current
                    }
                }
                current = current.next
            }

            startIter?.next = greaterOrEqual
            greaterOrEqualIter?.next = null

            return start ?: greaterOrEqual
        }
    }

}

fun main() {
    PartitionList.partition(
        ListNode(1)
            .apply {
                next = ListNode(4)
                    .apply {
                        next = ListNode(3)
                            .apply {
                                next = ListNode(2)
                                    .apply {
                                        next = ListNode(5)
                                            .apply {
                                                next = ListNode(2)
                                            }
                                    }
                            }
                    }

            },
        3
    )
}