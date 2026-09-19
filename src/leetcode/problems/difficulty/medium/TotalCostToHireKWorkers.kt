package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.PriorityQueue

/**
 * 2462. Total Cost to Hire K Workers
 * https://leetcode.com/problems/total-cost-to-hire-k-workers/?envType=study-plan-v2&envId=leetcode-75
 */
class TotalCostToHireKWorkers {

    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        if (k >= costs.size) return costs.sumOf { it.toLong() }
        var sum = 0L
        var start = 0
        var end = costs.lastIndex
        val startHeap = PriorityQueue(
            compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first }
        )
        val endHeap = PriorityQueue(
            compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first }
        )
        repeat(k) {
            while (startHeap.size < candidates && start <= end) {
                startHeap.add(Pair(start, costs[start++]))
            }

            while (endHeap.size < candidates && end >= start) {
                endHeap.add(Pair(end, costs[end--]))
            }
            if (startHeap.isEmpty()) {
                sum += endHeap.remove().second
            } else if (endHeap.isEmpty()) {
                sum += startHeap.remove().second
            } else if (startHeap.peek().second == endHeap.peek().second) {
                sum += if (startHeap.peek().first == endHeap.peek().first) {
                    startHeap.remove()
                    endHeap.remove().second
                } else if (startHeap.peek().first < endHeap.peek().first) {
                    startHeap.remove().second
                } else {
                    endHeap.remove().second
                }
            } else if (startHeap.peek().second < endHeap.peek().second) {
                sum += startHeap.remove().second
            } else {
                sum += endHeap.remove().second
            }
        }
        return sum
    }

    fun totalCost2(costs: IntArray, k: Int, candidates: Int): Long {
        if (k >= costs.size) return costs.sumOf { it.toLong() }
        var sum = 0L
        var start = 0
        var end = costs.lastIndex
        val startHeap = PriorityQueue<Int>()
        val endHeap = PriorityQueue<Int>()
        repeat(k) {
            while (startHeap.size < candidates && start <= end) {
                startHeap.add(costs[start++])
            }

            while (endHeap.size < candidates && end >= start) {
                endHeap.add(costs[end--])
            }
            sum += if (startHeap.isEmpty()) {
                endHeap.remove()
            } else if (endHeap.isEmpty()) {
                startHeap.remove()
            } else if (startHeap.peek() <= endHeap.peek()) {
                startHeap.remove()
            } else {
                endHeap.remove()
            }
        }
        return sum
    }
}

fun main() {
    TotalCostToHireKWorkers().apply {
//        totalCost(intArrayOf(17, 12, 10, 2, 7, 2, 11, 20, 8), 3, 4).println()
        totalCost(
            intArrayOf(
                28,
                35,
                21,
                13,
                21,
                72,
                35,
                52,
                74,
                92,
                25,
                65,
                77,
                1,
                73,
                32,
                43,
                68,
                8,
                100,
                84,
                80,
                14,
                88,
                42,
                53,
                98,
                69,
                64,
                40,
                60,
                23,
                99,
                83,
                5,
                21,
                76,
                34
            ), 32, 12
        ).println()
//        totalCost(intArrayOf(1,2,4,1), 3, 3).println()
    }
}
