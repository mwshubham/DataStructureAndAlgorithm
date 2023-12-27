package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.LinkedList
import java.util.PriorityQueue

/**
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/
 * https://leetcode.com/problems/task-scheduler/submissions/1129543809/
 * https://leetcode.com/submissions/detail/1129544311/?from=explore&item_id=826
 */
class TaskScheduler {

    companion object {
        fun leastInterval(tasks: CharArray, n: Int): Int {
            var res = 0
            val arr = IntArray(26)
            tasks.forEach {
                arr[it - 'A'] += 1
            }
            arr.sortedDescending()
            val queue = PriorityQueue<Int>(reverseOrder())
            arr.forEach {
                if (it == 0) {
                    return@forEach
                }
                queue.add(it)
            }
            while (queue.isNotEmpty()) {
                val tempQueue = LinkedList<Int>()
                var tempCount = n + 1
                while (tempCount > 0 && queue.isNotEmpty()) {
                    val top = queue.poll()
                    tempQueue.add(top - 1)
                    res++
                    tempCount--
                }
                tempQueue.forEach {
                    if (it <= 0) {
                        return@forEach
                    }
                    queue.add(it)
                }
                if (queue.isEmpty()) break
                res += tempCount
            }
            return res
        }
    }
}

fun main() {
    TaskScheduler.leastInterval(
        charArrayOf(
            'A',
            'A',
            'A',
            'A',
            'A',
            'A',
            'B',
            'C',
            'D',
            'E',
            'F',
            'G'
        ), 2
    ).println()
}