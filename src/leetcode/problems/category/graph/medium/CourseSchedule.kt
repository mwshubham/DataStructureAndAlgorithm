package leetcode.problems.category.graph.medium

import java.util.*

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/
 * https://leetcode.com/submissions/detail/346495459/?from=/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/
 * https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 */
class CourseSchedule {

    /**
     * Runtime: 176 ms, faster than 100.00% of Kotlin online submissions for Course Schedule.
     * Memory Usage: 43 MB, less than 83.03% of Kotlin online submissions for Course Schedule.
     */
    fun canFinish2(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val size = prerequisites.size
        if (size == 0) return true
        if (size == 1) return true

        val adj = Array(numCourses) { ArrayList<Int>() }
        for (edge in prerequisites) {
            adj[edge[0]].add(edge[1])
        }

        val visited = Array(numCourses) { 0 }
        repeat (numCourses) {
            if (visited[it] == 0) {
                if (isCyclic(adj, visited, it)) {
                    return false
                }
            }
        }
        return true
    }

    /**
     * 0 - unvisited
     * 1 - processed
     * 2 - processing
     */
    private fun isCyclic(adj: Array<ArrayList<Int>>, visited: Array<Int>,  current: Int) : Boolean {
        if (visited[current] == 2) return true
        visited[current] = 2

        for (i in adj[current].indices){
            if (visited[adj[current][i]] != 1){
                if (isCyclic(adj, visited, adj[current][i])){
                    return true
                }
            }
        }
        visited[current] = 1
        return false
    }

    class Graph(
        val V: Int
    ) {
        private var adj: List<LinkedList<Int>> = ArrayList<LinkedList<Int>>(V).apply {
            for (i in 0 until V) {
                add(LinkedList<Int>())
            }
        }

        private fun isCyclicUtil(
            i: Int, visited: BooleanArray, recStack: BooleanArray
        ): Boolean {
            // Mark the current node as visited and
            // part of recursion stack
            if (recStack[i]) return true
            if (visited[i]) return false
            visited[i] = true
            recStack[i] = true
            val children = adj[i]
            for (c in children) if (isCyclicUtil(c, visited, recStack)) return true
            recStack[i] = false
            return false
        }

        fun addEdge(source: Int, dest: Int) {
            adj[source].add(dest)
        }

        // Returns true if the graph contains a
        // cycle, else false.
        // This function is a variation of DFS() in
        // https://www.geeksforgeeks.org/archives/18212
        fun isCyclic(): Boolean {
            // Mark all the vertices as not visited and
            // not part of recursion stack
            val visited = BooleanArray(V)
            val recStack = BooleanArray(V)


            // Call the recursive helper function to
            // detect cycle in different DFS trees
            for (i in 0 until V) if (isCyclicUtil(i, visited, recStack)) return true
            return false
        }

    }

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val size = prerequisites.size
        if (size == 0) return true
        if (size == 1) return true

        val graph = Graph(numCourses)
        prerequisites.forEach {
            graph.addEdge(it[0], it[1])
        }
        return !graph.isCyclic()
    }
}

fun main() {
//    val graph = CourseSchedule.Graph(4)
//    graph.addEdge(0, 1)
//    graph.addEdge(0, 2)
//    graph.addEdge(1, 2)
//    graph.addEdge(2, 0)
//    graph.addEdge(2, 3)
//    graph.addEdge(3, 3)
//    val graph = CourseSchedule.Graph(4)
//    graph.addEdge(0, 1)
//    graph.addEdge(1, 2)
//    graph.addEdge(2, 1)

//    if (graph.isCyclic()) {
//        println("Graph contains cycle")
//    } else {
//        println("Graph doesn't contain cycle")
//    }
}