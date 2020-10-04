package leetcode.challenge


/**
 * https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3483/
 * https://leetcode.com/submissions/detail/404312921/?from=/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3483/
 */
class RemoveCoveredIntervals {
    /**
     * Runtime: 180 ms, faster than 100.00% of Kotlin online submissions for Remove Covered Intervals.
     * Memory Usage: 36.5 MB, less than 100.00% of Kotlin online submissions for Remove Covered Intervals.
     */
    fun removeCoveredIntervalsWithoutSort(intervals: Array<IntArray>): Int {
        var counter = intervals.size

        var head: Node? = null
        var prev: Node? = null

        intervals.forEach {
            if (head == null) {
                head = Node(it)
                prev = head
            } else {
                prev?.next = Node(it)
                prev = prev?.next
            }
        }

        var start = head
        while (start != null) {
            val startInterval = start.interval
            var next = start.next
            var prev = start
            while (next != null) {
                val nextInterval = next.interval
                if (startInterval[0] <= nextInterval[0] && startInterval[1] >= nextInterval[1]) {
                    counter--
                    prev!!.next = next.next
                } else if (nextInterval[0] <= startInterval[0] && nextInterval[1] >= startInterval[1]) {
                    counter--
                    break
                } else {
                    prev = next
                }
                next = next.next
            }
            start = start.next
        }
        return counter
    }
}

class Node(
    val interval: IntArray,
    var next: Node? = null
)
