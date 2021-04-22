package leetcode.challenge.april

import kotlin1.println
import java.util.*
import kotlin.math.min


/**
 * 554. Brick Wall
 * https://leetcode.com/problems/brick-wall/
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3717/
 */
class BrickWall {
    companion object {
//        [[1],[1],[1]]
//        [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
//        [[3],[3],[3]]
//        [[3],[1, 2],[3]]
//        [[2],[2],[2]]
//        [[1, 1],[2],[2]]
//        [[100000000],[100000000],[100000000]]

        /**
         * Status: Memory Limit Exceeded
         */
        fun leastBricks(wall: List<List<Int>>): Int {
            if (wall[0].size == 1 && wall[0][0] == 1) return wall.size
            val width = wall[0].sum()
            val matrix = Array(wall.size) { ByteArray(width) }
            wall.forEachIndexed { i, list ->
                var count = 0
                list.forEachIndexed { j, item ->
                    val keyword: Byte = if (j % 2 == 0) 0 else 1
                    repeat(item) {
                        matrix[i][count++] = keyword
                    }
                }
            }
            var res = Int.MAX_VALUE
            var crossingBricks: Int
            for (i in 0 until width - 1) {
                crossingBricks = 0
                for (j in matrix.indices) {
                    if (matrix[j][i] == matrix[j][i + 1]) crossingBricks++
                }
                res = min(res, crossingBricks)
            }
            return res
        }

        /**
         *  Status: Time Limit Exceeded
         */
        fun leastBricks2(wall: MutableList<MutableList<Int>>): Int {
            if (wall[0].size == 1 && wall[0][0] == 1) return wall.size
            val width = wall[0].sum()
            val dp = Array(wall.size) { 0 }

            var res = Int.MAX_VALUE
            var crossingBricks: Int
            for (i in 0 until width - 1) {
                crossingBricks = 0
                for (j in dp.indices) {
                    wall[j][dp[j]]--
                    if (wall[j][dp[j]] > 0) crossingBricks++
                    if (wall[j][dp[j]] <= 0) dp[j]++
                }
//                kotlin.io.println("wall: $wall")
//                kotlin.io.println("dp: ${dp.asList()}")
//                kotlin.io.println("crossingBricks: $crossingBricks")
//                kotlin.io.println("")
//                kotlin.io.println("")
//                kotlin.io.println("")
                res = min(res, crossingBricks)
            }
            return res
        }

        /**
         * https://leetcode.com/submissions/detail/483809638/?from=explore&item_id=3717
         * Runtime: 264 ms, faster than 83.33% of Kotlin online submissions for Brick Wall.
         * Memory Usage: 47 MB, less than 100.00% of Kotlin online submissions for Brick Wall.
         */
        fun leastBricks3(wall: List<List<Int>>): Int {
            val map = HashMap<Int, Int>()
            var count = 0
            for (row in wall) {
                var sum = 0
                for (i in 0 until row.size - 1) {
                    sum += row[i]
                    map[sum] = map.getOrDefault(sum, 0) + 1
                    count = Math.max(count, map[sum]!!)
                }
            }

            return wall.size - count
        }
    }
}

fun main() {

//    BrickWall.leastBricks(
//        listOf(
//            listOf(3, 3, 3),
//            listOf(3, 3, 3),
//            listOf(3, 3, 3)
//        )
//    ).println()

    BrickWall.leastBricks2(
        mutableListOf(
            mutableListOf(1, 2, 2, 1),
            mutableListOf(3, 1, 2),
            mutableListOf(1, 3, 2),
            mutableListOf(2, 4),
            mutableListOf(3, 1, 2),
            mutableListOf(1, 3, 1, 1)
        )
    ).println()
}