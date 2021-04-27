package leetcode.problems.category.array.easy

import java.util.*


/**
 * 414. Third Maximum Number
 * https://leetcode.com/problems/third-maximum-number/
 *
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/
 * https://leetcode.com/submissions/detail/485755577/?from=explore&item_id=3231
 */
class ThirdMaximumNumber {
    companion object {
        /**
         * Java PriorityQueue O(n) + O(1)
         *
         * Runtime: 168 ms, faster than 94.17% of Kotlin online submissions for Third Maximum Number.
         * Memory Usage: 36.9 MB, less than 67.96% of Kotlin online submissions for Third Maximum Number.
         */
        fun thirdMax(nums: IntArray): Int {
            val pq = PriorityQueue<Int>(reverseOrder())
            val set: MutableSet<Int> = HashSet()
            for (i in nums) {
                if (!set.contains(i)) {
                    pq.offer(i)
                    set.add(i)
                    if (pq.size > 3) {
                        set.remove(pq.poll())
                    }
                }
            }
            if (pq.size < 3) {
                while (pq.size > 1) {
                    pq.poll()
                }
            }
            return pq.peek()
        }
    }
}