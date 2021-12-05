package leetcode.problems.category.array.medium

import kotlin.collections.LinkedHashSet

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/777/
 * https://leetcode.com/submissions/detail/597203638/?from=explore&item_id=777
 */
class SetMatrixZeroes {
    /**
     * Runtime: 240 ms, faster than 96.61% of Kotlin online submissions for Set Matrix Zeroes.
     * Memory Usage: 40.2 MB, less than 88.98% of Kotlin online submissions for Set Matrix Zeroes.
     */
    fun setZeroes(matrix: Array<IntArray>) {
        if (matrix.isEmpty()) return
        val rows = matrix.size
        val cols = matrix[0].size

        val rowsWithZeroes = LinkedHashSet<Int>()
        val colsWithZeroes = LinkedHashSet<Int>()

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (matrix[row][col] == 0) {
                    rowsWithZeroes.add(row)
                    colsWithZeroes.add(col)
                }
            }
        }

        rowsWithZeroes.forEach { row ->
            for (col in 0 until cols) {
                matrix[row][col] = 0
            }
        }

        colsWithZeroes.forEach { col ->
            for (row in 0 until rows) {
                matrix[row][col] = 0
            }
        }
    }
}