package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/806/
 * https://leetcode.com/submissions/detail/623198779/?from=explore&item_id=806
 */
class SearchA2DMatrixII {

    companion object {
        /**
         * TC:  O(m+n)
         */
        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            if (matrix.isEmpty() || matrix[0].isEmpty()) {
                return false
            }
            var row = 0
            var col = matrix[0].lastIndex

            while (row <= matrix.lastIndex && col >= 0) {
                if (target == matrix[row][col]) {
                    return true
                } else if (target < matrix[row][col]) {
                    col--
                } else {
                    row++
                }
            }
            return false
        }
    }
}

fun main() {
    SearchA2DMatrixII.searchMatrix(
        arrayOf(
            intArrayOf(1, 4, 7, 11, 16),
            intArrayOf(2, 5, 8, 12, 19),
            intArrayOf(3, 6, 9, 16, 22),
            intArrayOf(10, 13, 14, 17, 24),
            intArrayOf(18, 21, 23, 26, 30)
        ),
        20
    ).println()
}