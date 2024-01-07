package leetcode.problems.category.graph

import searching.intArray
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/description
 * https://leetcode.com/problems/number-of-provinces/submissions/1138403750
 * https://leetcode.com/problems/number-of-provinces/submissions/1139387948/
 */
class NumberOfProvinces {

    companion object {
        fun findCircleNum(isConnected: Array<IntArray>): Int {
//            val adj = HashMap<Int, LinkedList<Int>>()
//            isConnected.forEachIndexed { i, ints ->
//                ints.forEachIndexed { j, value ->
//                    if (i != j && value == 1) {
//                        adj.getOrPut(i) { LinkedList() }.add(j)
//                    }
//                }
//            }
            var res = 0
            val visited = BooleanArray(isConnected.size)
//            val queue = LinkedList<Int>()
            isConnected.forEachIndexed { index, _ ->
                if (!visited[index]) {
                    res += 1
                    dfs(index, isConnected, visited)
//                    visited[index] = true
//                    adj[index]?.let {
//                        queue.addAll(it)
//                    }
//                    while (queue.isNotEmpty()) {
//                        val front = queue.pop()
//                        if (!visited[front]) {
//                            visited[front] = true
//                            adj[front]?.let {
//                                queue.addAll(it)
//                            }
//                        }
//                    }
                }
            }
            return res
        }

        private fun dfs(node: Int, isConnected: Array<IntArray>, visited: BooleanArray) {
            visited[node] = true
            isConnected[node].forEachIndexed { index, i ->
                if (i == 1 && !visited[index]) {
                    dfs(index, isConnected, visited)
                }
            }
        }
    }
}

fun main() {
    NumberOfProvinces.findCircleNum(
        arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1)
        )
    )
}