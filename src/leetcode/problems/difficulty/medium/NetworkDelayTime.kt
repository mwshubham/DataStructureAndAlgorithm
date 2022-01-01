package leetcode.problems.difficulty.medium

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 743. Network Delay Time
 * https://leetcode.com/problems/network-delay-time/
 */
class NetworkDelayTime {

    companion object {
        /**
         * Using Djikstra / BFS Algorithm with Min Heap
         *
         * Runtime: 328 ms, faster than 53.85% of Kotlin online submissions for Network Delay Time.
         * Memory Usage: 46.9 MB, less than 69.23% of Kotlin online submissions for Network Delay Time.
         */
        fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
            var nodes = n

            val map = HashMap<Int, ArrayList<Pair<Int, Int>>>()
            times.forEach {
                map.putIfAbsent(it[0], ArrayList())
                map[it[0]]?.add(Pair(it[1], it[2]))
            }

            // Min Heap, increasing by time. (node, time)
            val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
            pq.add(Pair(k, 0))

            val visited = BooleanArray(n + 1)
            var res = 0

            // V Times
            while (pq.isNotEmpty()) {
                val curr = pq.poll()
                val currNode = curr.first
                val currDist = curr.second
                if (visited[currNode]) continue
                visited[currNode] = true
                res = currDist

                nodes--

                // Early return
                if (nodes == 0) return res

                map[currNode]?.forEach {
                    // PQ poll() and add() takes O(log E)
                    pq.add(Pair(it.first, it.second + res))
                }
            }
            return if (nodes == 0) res else -1
        }
    }
}