package leetcode.problems.category.graph.medium


import kotlin.collections.ArrayList
import kotlin.math.min

/**
 * 787. Cheapest Flights Within K Stops
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
class CheapestFlightsWithinKStops {
    companion object {
        var fare = Int.MAX_VALUE

        /**
         * Time Limit Exceeded
         */
        fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
            val adj = Array(n) { ArrayList<Pair<Int, Int>>() }
            for (edge in flights) {
                adj[edge[0]].add(Pair(edge[1], edge[2]))
            }

            val visited = BooleanArray(n)
            findCheapestPrice(adj, visited, src, dst, k, 0)
            if (fare == Int.MAX_VALUE) return -1
            return fare
        }

        private fun findCheapestPrice(adj: Array<ArrayList<Pair<Int, Int>>>, visited: BooleanArray, src: Int, dst: Int, k: Int, totalFare: Int) {
            if (k < -1) {
                return
            }

            if (src == dst) {
                fare = min(fare, totalFare)
                return
            }

            visited[src] = true

            repeat(adj[src].size) {
                if (!visited[adj[src][it].first] && (totalFare + adj[src][it].second <= fare)){
                    findCheapestPrice(adj, visited, adj[src][it].first, dst, k - 1, totalFare + adj[src][it].second)
                }
            }
            visited[src] = false
        }
    }
}