package leetcode.problems.dynamicprogramming.medium

import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
class MinimumPathSum {

    companion object {
        /**
         * Runtime: 184 ms, faster than 71.43% of Kotlin online submissions for Minimum Path Sum.
         * Memory Usage: 38.6 MB, less than 39.29% of Kotlin online submissions for Minimum Path Sum.
         */
        fun minPathSum(grid: Array<IntArray>): Int {
            val rows = grid.size
            val cols = grid[0].size
            for (row in 1 until rows) {
                grid[row][0] += grid[row - 1][0]
            }
            for (col in 1 until cols) {
                grid[0][col] += grid[0][col - 1]
            }

            for (row in 1 until rows) {
                for (col in 1 until cols) {
                    grid[row][col] += min(grid[row - 1][col], grid[row][col - 1])
                }
            }
            return grid[rows - 1][cols - 1]
        }
    }
}