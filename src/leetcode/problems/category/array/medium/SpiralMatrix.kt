package leetcode.problems.category.array.medium

/**
 *
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 */
class SpiralMatrix {
    companion object {

        /**
         * Runtime: 140 ms, faster than 86.90% of Kotlin online submissions for Spiral Matrix.
         * Memory Usage: 34.2 MB, less than 35.71% of Kotlin online submissions for Spiral Matrix.
         */
        fun spiralOrder(matrix: Array<IntArray>): List<Int> {
            val result = ArrayList<Int>()
            val rows = matrix.size
            val cols = matrix[0].size
            var count = 0
            var i = 0
            var j = 0
            while (count <= rows * cols) {
                while (j < cols && matrix[i][j] != Int.MIN_VALUE) {
                    result.add(matrix[i][j])
                    matrix[i][j] = Int.MIN_VALUE
                    j++
                }
                j--
                while (i < rows && matrix[i][j] != Int.MIN_VALUE) {
                    result.add(matrix[i][j])
                    matrix[i][j] = Int.MIN_VALUE
                    i++
                }
                i--
                while (j >= 0 && matrix[i][j] != Int.MIN_VALUE) {
                    result.add(matrix[i][j])
                    matrix[i][j] = Int.MIN_VALUE
                    j--
                }
                j++
                while (i >= 0 && matrix[i][j] != Int.MIN_VALUE) {
                    result.add(matrix[i][j])
                    matrix[i][j] = Int.MIN_VALUE
                    i--
                }
                i++
                count++
            }
            return result
        }
    }
}