package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 253. Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
class MeetingRoomsII {
    companion object {
        /**
         * Runtime: 231 ms, faster than 99.07% of Kotlin online submissions for Meeting Rooms II.
         * Memory Usage: 39.7 MB, less than 96.30% of Kotlin online submissions for Meeting Rooms II.
         */
        fun minMeetingRooms(intervals: Array<IntArray>): Int {
            val startArr = Array(intervals.size) { -1 }
            val endArr = Array(intervals.size) { -1 }

            intervals.forEachIndexed { index, interval ->
                startArr[index] = interval[0]
                endArr[index] = interval[1]
            }
            startArr.sort()
            endArr.sort()
            var room = 0
            var endIdx = 0
            startArr.forEachIndexed { _, start ->
                if (start < endArr[endIdx]) {
                    room++
                } else {
                    endIdx++
                }
            }
            return room
        }
    }
}

fun main() {
//    Input: intervals = [[0,30],[5,10],[15,20]]
//    Output: false
    val intervals = Array(3) { intArrayOf() }
    intervals[0] = intArrayOf(0, 30)
    intervals[1] = intArrayOf(5, 10)
    intervals[2] = intArrayOf(15, 20)
    MeetingRoomsII.minMeetingRooms(intervals).println()
}