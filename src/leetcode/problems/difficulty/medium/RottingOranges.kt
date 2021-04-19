package leetcode.problems.difficulty.medium

import java.util.*

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 */
class RottingOranges {
    companion object {
        /**
         * Runtime: 164 ms, faster than 94.44% of Kotlin online submissions for Rotting Oranges.
         * Memory Usage: 39.8 MB, less than 25.00% of Kotlin online submissions for Rotting Oranges.
         */
        fun orangesRotting(grid: Array<IntArray>): Int {
            if (grid.isEmpty()) return 0
            val rows = grid.size
            val cols = grid[0].size

            val queue = LinkedList<Pair<Int, Int>>()
            var freshCount = 0

            //Put the position of all rotten oranges in queue
            //count the number of fresh oranges
            for (row in 0 until rows) {
                for (col in 0 until cols) {
                    if (grid[row][col] == 2) {
                        queue.add(Pair(row, col))
                    } else if (grid[row][col] == 1) {
                        freshCount++
                    }
                }
            }

            //if count of fresh oranges is zero --> return 0
            if (freshCount == 0) return 0
            val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

            var noOfMinutes = 0
            while (queue.isNotEmpty()) {
                noOfMinutes++
                val size = queue.size
                repeat(size) {
                    queue.poll().let { point ->
                        for (dir in dirs) {
                            val x = point.first + dir[0]
                            val y = point.second + dir[1]

                            //if x or y is out of bound
                            //or the orange at (x , y) is already rotten
                            //or the cell at (x , y) is empty
                            //we do nothing
                            if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue

                            //mark the orange at (x , y) as rotten
                            grid[x][y] = 2

                            //put the new rotten orange at (x , y) in queue
                            queue.add(Pair(x, y))
                            freshCount--
                        }
                    }
                }
            }
            // -1 -> Impossible
            return if (freshCount == 0) noOfMinutes - 1 else -1
        }
    }
}