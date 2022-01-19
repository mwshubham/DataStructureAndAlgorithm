package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max
import kotlin.math.min

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/803/
 */
class MergeIntervals {
    companion object {

        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            if (intervals.size <= 1) return intervals
            Arrays.sort(intervals) { a, b ->
                a[0].compareTo(b[0])
            }
            val res = ArrayList<IntArray>()
            var newInterval = intervals[0]
            res.add(intervals[0])
            intervals.forEach { interval ->
                if (interval[0] <= newInterval[1]) {
                    newInterval[1] = max(interval[1], newInterval[1])
                } else {
                    newInterval = interval
                    res.add(interval)
                }
            }

            return res.toTypedArray()
        }

    }

}

fun main() {
    MergeIntervals.merge(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        )
    ).println()
}
