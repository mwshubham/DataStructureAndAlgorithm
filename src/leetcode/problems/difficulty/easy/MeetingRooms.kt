package leetcode.problems.difficulty.easy

import kotlin1.println
import java.util.*

/**
 * 252. Meeting Rooms
 * https://leetcode.com/problems/meeting-rooms/
 */
class MeetingRooms {

    companion object {
        /**
         * Runtime: 349 ms, faster than 82.69% of Kotlin online submissions for Meeting Rooms.
         * Memory Usage: 43.5 MB, less than 84.62% of Kotlin online submissions for Meeting Rooms.
         */
        fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
           if (intervals.isEmpty()) return true
            Arrays.sort(intervals) { o1, o2 -> o1[0] - o2[0] }
            for (i in 1..intervals.lastIndex) {
                if (intervals[i][0] < intervals[i-1][1]) {
                    return false
                }
            }
            return true
        }
    }
}

fun main(){
//    Input: intervals = [[0,30],[5,10],[15,20]]
//    Output: false
    val intervals = Array(3){ intArrayOf() }
    intervals[0]  = intArrayOf(0, 30)
    intervals[1]  = intArrayOf(5, 10)
    intervals[2]  = intArrayOf(15, 20)
    MeetingRooms.canAttendMeetings(intervals).println()
}