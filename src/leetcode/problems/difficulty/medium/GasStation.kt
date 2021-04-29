package leetcode.problems.difficulty.medium

import kotlin.math.cos

/**
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/
 */
//[1,2,3,4,5]
//[3,4,5,1,2]
//[2,3,4]
//[3,4,3]
//[1, 4, 1, 15]
//[4, 3, 4, 2]
class GasStation {
    companion object {
        /**
         * Runtime: 168 ms, faster than 85.96% of Kotlin online submissions for Gas Station.
         * Memory Usage: 35.3 MB, less than 94.74% of Kotlin online submissions for Gas Station.
         */
        fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            var total = 0
            var tank = 0
            var start = 0
            for (i in gas.indices) {
                if (gas[i] >= cost[i]) {
                    if (tank < 0) {
                        start = i
                        tank = 0
                    }
                }
                total += gas[i] - cost[i]
                tank += gas[i] - cost[i]
            }
            return if (total < 0) -1 else start
        }
    }
}