package leetcode.problems.category.graph.medium

import kotlin1.println

/**
 * 802. Find Eventual Safe States
 * https://leetcode.com/problems/find-eventual-safe-states/description
 */
class FindEventualSafeStates {

    companion object {

        private const val STATE_SAFE = 1
        private const val STATE_UNSAFE = 0
        private const val STATE_PROCESSING = 2
        private const val STATE_UNKNOWN = -1

        fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
            val state = Array(graph.size) { STATE_UNKNOWN }
            val res = ArrayList<Int>()
            graph.forEachIndexed { node, _ ->
                isSafeNode(graph, node, state).apply {
                    if (this) {
                        res.add(node)
                    }
                }
            }
            return res
        }

        private fun isSafeNode(
            graph: Array<IntArray>,
            node: Int,
            state: Array<Int>
        ): Boolean {
            if (state[node] == STATE_SAFE) return true
            if (state[node] == STATE_UNSAFE) return false
            if (state[node] == STATE_PROCESSING) return false

            state[node] = STATE_PROCESSING

            graph[node].forEach { adjacent ->
                if (!isSafeNode(graph, adjacent, state)) {
                    state[adjacent] = STATE_UNSAFE
                    state[node] = STATE_UNKNOWN
                    return false
                }
            }
            state[node] = STATE_SAFE
            return true
        }
    }
}

fun main() {
//    FindEventualSafeStates.eventualSafeNodes(
//        arrayOf(
//            intArrayOf(1, 2),
//            intArrayOf(2, 3),
//            intArrayOf(5),
//            intArrayOf(0),
//            intArrayOf(5),
//            intArrayOf(),
//            intArrayOf()
//        )
//    ).println()
    FindEventualSafeStates.eventualSafeNodes(
        arrayOf(
            intArrayOf(),
            intArrayOf(0, 2, 3, 4),
            intArrayOf(3),
            intArrayOf(4),
            intArrayOf(),
        )
    ).println()
}