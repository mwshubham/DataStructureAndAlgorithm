package leetcode.problems.category.graph.medium

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/792/
 * https://leetcode.com/submissions/detail/600592388/?from=explore&item_id=792
 */
//[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
//[["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
//[["1","1","1"],["0","1","0"],["1","1","1"]]
class NumberOfIslands {

    /**
     * Runtime: 232 ms, faster than 75.54% of Kotlin online submissions for Number of Islands.
     * Memory Usage: 44.9 MB, less than 78.54% of Kotlin online submissions for Number of Islands.
     */
    companion object {
        fun numIslands(grid: Array<CharArray>): Int {
            if (grid.isEmpty() || grid.getOrNull(0)?.size == 0) return 0
            val m = grid.size
            val n = grid[0].size
            var count = 0
            for (row in grid.indices) {
                for (col in grid[0].indices) {
                    if (grid[row][col] == '1') {
                        count++
                        numIslands(grid, row, col, m, n)
                    }
                }
            }
            return count
        }

        fun numIslands(grid: Array<CharArray>, row: Int, col: Int, m: Int, n: Int) {
            if (row !in 0 until m || col !in 0 until n) return
            if (grid[row][col] == '1') {
                grid[row][col] = '0'
                numIslands(grid, row + 1, col, m, n)
                numIslands(grid, row, col + 1, m, n)
                numIslands(grid, row - 1, col, m, n)
                numIslands(grid, row, col - 1, m, n)
            }
        }
    }
}