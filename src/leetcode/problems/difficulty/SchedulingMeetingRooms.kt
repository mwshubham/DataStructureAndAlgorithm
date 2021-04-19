package leetcode.problems.difficulty

import java.util.*


class SchedulingMeetingRooms {

    companion object {
        fun minMeetingRooms(intervals: Array<Interval>?): Int {
            if (intervals == null || intervals.isEmpty()) return 0
            Arrays.sort(intervals) { o1, o2 ->
                when {
                    o1.start < o2.start -> {
                        -1
                    }
                    o1.start > o2.start -> {
                        1
                    }
                    else -> {
                        0
                    }
                }
            }
            val queue = PriorityQueue<Float>()
            var numberOfMeetingRoomsUsed = 1
            queue.offer(intervals[0].end)
            for (i in 1 until intervals.size) {
                if (intervals[i].start < queue.peek()) {
                    numberOfMeetingRoomsUsed++
                } else {
                    queue.poll()
                }
                queue.offer(intervals[i].end)
            }
            return numberOfMeetingRoomsUsed
        }
    }
}

fun main() {
    val intervals = arrayOf(
        Interval(09.00f, 09.30f),
        Interval(07.00f, 09.00f),
        Interval(08.00f, 10.00f),
        Interval(09.30f, 10.00f)
    )
    println(SchedulingMeetingRooms.minMeetingRooms(intervals))
}

class Interval(
    val start: Float,
    val end: Float
)