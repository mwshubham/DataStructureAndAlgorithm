package leetcode.problems.category.graph.medium

import java.util.LinkedList

/**
 * 2316. Count Unreachable Pairs of Nodes in an Undirected Graph
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/submissions/921620688/
 */
class CountUnreachablePairsOfNodesInAnUndirectedGraph {

    companion object {
        fun countPairs(n: Int, edges: Array<IntArray>): Long {
            val adj = HashMap<Int, LinkedList<Int>>(n)
            edges.forEach {
                adj.getOrPut(it[0]) { LinkedList() }.add(it[1])
                adj.getOrPut(it[1]) { LinkedList() }.add(it[0])
            }

            var res = 0L
            var remainingNodes = n.toLong()
            val visited = Array(n) { false }
            for (i in 0 until n) {
                if (!visited[i]) {
                    val sizeOfComponent : Long = sizeOfComponent(visited, adj, i).toLong()
                    remainingNodes -= sizeOfComponent
                    res += sizeOfComponent * remainingNodes
                }
            }
            return res
        }

        private fun sizeOfComponent(visited: Array<Boolean>, adj: HashMap<Int, LinkedList<Int>>, node: Int) : Int {
            visited[node] = true

            var sizeOfComponent = 1

            if (!adj.containsKey(node)) {
                return sizeOfComponent
            }

            adj[node]?.forEach {
                if (!visited[it]) {
                    sizeOfComponent += sizeOfComponent(visited, adj, it)
                }
            }
            return sizeOfComponent
        }
    }
}