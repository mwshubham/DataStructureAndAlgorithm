package leetcode.challenge.may21

import java.util.*

/**
 * 630. Course Schedule III
 * https://leetcode.com/problems/course-schedule-iii/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3729/
 * https://leetcode.com/submissions/detail/487889367/?from=explore&item_id=3729
 */
class CourseScheduleIII {
    companion object {
        /**
         * Once you make sure a course fits in, you can remove it any time later and the other courses
         * you have added after would still fit. So it is always safe to remove any course in the past.
         * Time complexity O(nlogn) and space complexity O(n) where n = number of courses.
         *
         * Runtime: 484 ms, faster than 75.00% of Kotlin online submissions for Course Schedule III.
         * Memory Usage: 58.4 MB, less than 75.00% of Kotlin online submissions for Course Schedule III.
         */
        fun scheduleCourse(courses: Array<IntArray>): Int {
            // Sort the courses by their deadlines (Greedy! We have to deal with courses with early deadlines first)
            Arrays.sort(courses) { o1, o2 -> o1[1] - o2[1] }
            // Max Heap
            val pq = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
            var time = 0
            for (course in courses) {
                time += course[0]
                // add current course to a priority queue
                pq.add(course[0])
                // If time exceeds, drop the previous course which costs the most time. (That must be the best choice!)
                if (time > course[1]) {
                    time -= pq.poll()
                }
            }
            return pq.size
        }
    }
}


fun main() {
    CourseScheduleIII.scheduleCourse(
        arrayOf(
            intArrayOf(100, 200),
            intArrayOf(200, 1300),
            intArrayOf(1000, 1250),
            intArrayOf(2000, 3200)
        )
    )
}