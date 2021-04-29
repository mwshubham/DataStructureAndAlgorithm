package leetcode.challenge.april

import java.util.*
import kotlin.math.max

/**
 * 1642. Furthest Building You Can Reach
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 */
class FurthestBuildingYouCanReach {

    companion object {

        /**
         * https://leetcode.com/problems/furthest-building-you-can-reach/discuss/918515/JavaC%2B%2BPython-Priority-Queue
         *
         * Runtime: 436 ms, faster than 51.28% of Kotlin online submissions for Furthest Building You Can Reach.
         * Memory Usage: 55.3 MB, less than 15.38% of Kotlin online submissions for Furthest Building You Can Reach.
         */
        fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
            val pq = PriorityQueue<Int>()
            var bricks = bricks
            for (i in 0 until heights.lastIndex) {
                val diff = heights[i + 1] - heights[i]
                if (diff > 0) {
                    pq.add(diff)
                }
                if (pq.size > ladders) {
                    bricks -= pq.poll()
                }
                if (bricks < 0) {
                    return i
                }
            }
            return heights.lastIndex
        }

//        /**
//         * We cannot solve this using 1 Dimensional DP as it has three state for each index.
//         */

//        fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
//            dp = IntArray(heights.size) { -1 }
//            return furthestBuilding(heights, 0, bricks, ladders)
//        }
//
//
//        private lateinit var dp: IntArray
//        fun furthestBuildingUsingDP(heights: IntArray, bricks: Int, ladders: Int): Int {
//            dp = IntArray(heights.size) { -1 }
//            return furthestBuilding(heights, 0, bricks, ladders)
//        }
//

//        fun furthestBuilding(heights: IntArray, index: Int, bricks: Int, ladders: Int): Int {
//            if (dp[index] != -1) return dp[index]
//            if (index == heights.lastIndex) {
//                dp[index] = index
//                return dp[index]
//            }
//            if (heights[index] >= heights[index + 1]) {
//                dp[index] = furthestBuilding(heights, index + 1, bricks, ladders)
//                return dp[index]
//            }
//
//            val diff = heights[index + 1] - heights[index]
//            if (ladders > 0 && diff <= bricks) {
//                dp[index] = max(
//                    furthestBuilding(heights, index + 1, bricks - diff, ladders),
//                    furthestBuilding(heights, index + 1, bricks, ladders - 1)
//                )
//                return dp[index]
//            }
//
//            if (ladders == 0 && diff <= bricks) {
//                dp[index] = furthestBuilding(heights, index + 1, bricks - diff, ladders)
//                return dp[index]
//            }
//            if (ladders != 0 && diff >= bricks) {
//                dp[index] = furthestBuilding(heights, index + 1, bricks, ladders - 1)
//                return dp[index]
//            }
//            dp[index] = index
//            return dp[index]
//        }
    }
}

fun main() {
    FurthestBuildingYouCanReach.furthestBuilding(
        intArrayOf(1, 5, 1, 2, 3, 4, 10000),
        4,
        1
    )
}