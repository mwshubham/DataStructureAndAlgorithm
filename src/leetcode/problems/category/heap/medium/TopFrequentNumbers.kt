package leetcode.problems.category.heap.medium

import java.util.*
import kotlin.collections.LinkedHashMap

// https://leetcode.com/problems/top-k-frequent-elements/
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3393/
// https://leetcode.com/submissions/detail/368138011/?from=/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3393/
class TopFrequentNumbers {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty() || k == 0) {
            return intArrayOf()
        }
        val pq = PriorityQueue<Pair<Int, Int>>(Comparator { o1, o2 ->
            o2.second - o1.second
        })
        val map = LinkedHashMap<Int, Int>()
        nums.forEach {
            map[it] = map[it]?.plus(1) ?: 1
        }
        map.forEach {
            pq.add(it.toPair())
        }

        return IntArray(k).apply {
            (0 until k).forEach {
                set(it, pq.remove().first)
            }
        }
    }
}

fun main() {
    TopFrequentNumbers().topKFrequent(intArrayOf(1, 2, 3, 4, 1, 1, 2, 3, 4), 2)
}