package leetcode.problems.category.graph.medium

import java.util.*
import kotlin.collections.ArrayList

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 */
class CourseScheduleII {

    companion object {
        /**
         * Runtime: 204 ms, faster than 96.88% of Kotlin online submissions for Course Schedule II.
         * Memory Usage: 43 MB, less than 89.58% of Kotlin online submissions for Course Schedule II.
         */
        fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
            val adj = Array(numCourses) { ArrayList<Int>() }
            for (edge in prerequisites) {
                adj[edge[1]].add(edge[0])
            }

            // Detect Cycle
            val visitedArr = Array(numCourses) { 0 }
            for (it in 0 until numCourses) {
                if (visitedArr[it] == 0) {
                    if (isCyclic(adj, visitedArr, it)) {
                        return IntArray(0)
                    }
                }
            }

            // Topological Sort
            val stack = Stack<Int>()
            val visited = BooleanArray(numCourses)
            for (it in 0 until numCourses) {
                dfs(adj, visited, stack, it)
            }
            val res = IntArray(numCourses)
            for (it in 0 until numCourses) {
                res[it] = stack.pop()
            }
            return res
        }

        private fun dfs(adj: Array<ArrayList<Int>>, visited: BooleanArray, stack: Stack<Int>, current: Int) {
            if (visited[current]) return
            visited[current] = true
            for (item in adj[current]) {
                dfs(adj, visited, stack, item)
            }
            stack.push(current)
        }

        /**
         * 0 - unvisited
         * 1 - processed
         * 2 - processing
         */
        private fun isCyclic(adj: Array<java.util.ArrayList<Int>>, visited: Array<Int>, current: Int): Boolean {
            if (visited[current] == 2) return true
            visited[current] = 2

            for (i in adj[current].indices) {
                if (visited[adj[current][i]] != 1) {
                    if (isCyclic(adj, visited, adj[current][i])) {
                        return true
                    }
                }
            }
            visited[current] = 1
            return false
        }

    }


}

fun main() {
    CourseScheduleII.findOrder(
        4, Array(4) {
            when (it) {
                0 -> intArrayOf(1, 0)
                1 -> intArrayOf(2, 0)
                2 -> intArrayOf(3, 1)
                3 -> intArrayOf(3, 2)
                else -> intArrayOf()
            }
        }
    )
}