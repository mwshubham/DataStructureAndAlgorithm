package leetcode.problems.category.array.medium

import kotlin1.println

/**
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 */
class SpiralMatrix2 {

    companion object {
        fun generateMatrix(n: Int): Array<IntArray> {
            val result = Array(n) { IntArray(n) }
            var count = 1
            val maxCount = n * n

            var rowMin = 0
            var rowMax = n - 1
            var colMin = 0
            var colMax = n - 1

            while (count <= maxCount) {
                for (i in colMin..colMax) {
                    result[colMin][i] = count++
                }
                rowMin++
                if (count > maxCount) break

                for (i in rowMin..rowMax) {
                    result[i][colMax] = count++
                }
                colMax--
                if (count > maxCount) break

                for (i in colMax downTo colMin) {
                    result[rowMax][i] = count++
                }
                rowMax--
                if (count > maxCount) break

                for (i in rowMax downTo rowMin) {
                    result[i][colMin] = count++
                }
                colMin++
            }
            return result
        }
    }
}

fun main() {
    SpiralMatrix2.generateMatrix(2).println()
}