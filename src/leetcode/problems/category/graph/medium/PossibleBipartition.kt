package leetcode.problems.category.graph.medium

import java.util.*
import kotlin.collections.ArrayList

/**
 * 886. Possible Bipartition
 * https://leetcode.com/problems/possible-bipartition/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/
 * https://leetcode.com/submissions/detail/345664599/?from=/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/
 */
class PossibleBipartition {

    /**
     * Runtime: 392 ms, faster than 95.00% of Kotlin online submissions for Possible Bipartition.
     * Memory Usage: 51.9 MB, less than 90.00% of Kotlin online submissions for Possible Bipartition.
     */
    fun possibleBipartition2(N: Int, dislikes: Array<IntArray>): Boolean {
        val adj = Array(N + 1) { ArrayList<Int>() }
        for (edge in dislikes) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }

        val color = Array(N + 1) { -1}
        for (node in 1..N) {
            if (color[node] == -1) {
                if (!isBipartite(adj, N, node, color)) {
                    return false
                }
            }
        }
        return true
    }

    private fun isBipartite(adj: Array<ArrayList<Int>>, N: Int, node: Int, color: Array<Int>) : Boolean {
        val q = LinkedList<Int>()
        q.push(node)
        color[node] = 1

        while (q.isNotEmpty()) {
            val curr = q.first()
            q.pop()
            for (element in adj[curr]) {
                // Odd cycle
                if (color[element] == color[curr]) return false
                // Unvisited element
                if (color[element] == -1) {
                    color[element] = 1 - color[curr]
                    q.push(element)
                }
            }
        }
        return true
    }

    private lateinit var graph: Array<ArrayList<Int>>
    private lateinit var color: MutableMap<Int, Int>

    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        graph = Array(N + 1) { _ -> ArrayList<Int>() }
        for (edge in dislikes) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        color = HashMap<Int, Int>()
        for (node in 1..N) if (!color.containsKey(node) && !dfs(node, 0)) return false
        return true
    }

    private fun dfs(node: Int, c: Int): Boolean {
        if (color.containsKey(node)) return color[node] == c
        color[node] = c
        for (nei in graph[node]) if (!dfs(nei, c xor 1)) return false
        return true
    }


//    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
//        if (dislikes.isEmpty()) return true
//
//        val setA = HashSet<Int>()
//        val setB = HashSet<Int>()
//
//        val mutableList = dislikes.toMutableList()
//        while (true) {
//            setA.add(dislikes[0][0])
//            setB.add(dislikes[0][1])
//            mutableList.removeAt(0)
//            if (mutableList.size == 0){
//                return true
//            }
//            mutableList.iterator().iterator().apply {
//                if (hasNext()) {
//                    iterator().next().apply {
//                        val item = this
//                        var oneInA = setA.contains(item[0])
//                        var oneInB = setB.contains(item[0])
//                        var twoInA = setA.contains(item[1])
//                        var twoInB = setB.contains(item[1])
//                        // if found item[0] in any one set
//                        if (oneInA || oneInB) {
//                            if (oneInA) {
//                                setB.add(item[1])
//                            } else {
//                                setA.add(item[1])
//                            }
//                            mutableList.remove(this)
//                        } else if (twoInA || twoInB) {
//                            if (twoInA) {
//                                setB.add(item[0])
//                            } else {
//                                setA.add(item[0])
//                            }
//                            mutableList.remove(this)
//                        }
////                    else {
////                        setA.add(item[0])
////                        setB.add(item[1])
////                    }
//                        oneInA = setA.contains(item[0])
//                        oneInB = setB.contains(item[0])
//                        twoInA = setA.contains(item[1])
//                        twoInB = setB.contains(item[1])
//
//                        if ((oneInA && oneInB) || (twoInA && twoInB)) {
//                            return false
//                        }
//                    }
//                }
//            }
//        }
//
////        for (index in 1 until dislikes.size) {
////
////        }
//        return true
//    }
}

// 5
//[[1,2],[3,4],[4,5],[3,5]]
// 10
//[[4,7],[4,8],[2,8],[8,9],[1,6],[5,8],[1,2],[6,7],[3,10],[8,10],[1,5],[7,10],[1,10],[3,5],[3,6],[1,4],[3,9],[2,3],[1,9],[7,9],[2,7],[6,8],[5,7],[3,4]]
private val testCases = arrayOf(
    Triple(
        1, arrayOf(), true
    ),
    Triple(
        4, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4)
        ), true
    ),
    Triple(
        5, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(3, 5)
        ), false
    ),
    Triple(
        3, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 3)
        ), false
    ),
    Triple(
        5, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(1, 5)
        ), false
    )
)

fun main() {
    val instance = PossibleBipartition()
    for (testCase in testCases) {
        val calculatedAns = instance.possibleBipartition(testCase.first, testCase.second)
        println("correctAns: ${testCase.third}")
        println("calculatedAns: $calculatedAns")
        println(testCase.third == calculatedAns)
    }
}


