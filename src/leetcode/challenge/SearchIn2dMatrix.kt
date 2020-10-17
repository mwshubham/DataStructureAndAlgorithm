@file:Suppress("unused")

package leetcode.challenge


/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3497/
 * https://leetcode.com/submissions/detail/409749312/?from=/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3497/
 */
class SearchIn2dMatrix {

    /**
     * Runtime: 168 ms, faster than 85.96% of Kotlin online submissions for Search a 2D Matrix.
     * Memory Usage: 34.5 MB, less than 5.26% of Kotlin online submissions for Search a 2D Matrix.
     */
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }
        val rows = matrix.size
        val columns = matrix[0].size

        var left = 0
        var right = rows * columns - 1

        while (right >= left) {
            val mid = left + (right - left) / 2
            val midValue = matrix[(mid / columns)][mid % columns]
            when {
                midValue == target -> {
                    return true
                }
                midValue < target -> {
                    left = mid + 1
                }
                else -> {
                    right = mid - 1
                }
            }
        }
        return false
    }

    /**
     * Runtime: 176 ms, faster than 73.68% of Kotlin online submissions for Search a 2D Matrix.
     * Memory Usage: 35.3 MB, less than 5.26% of Kotlin online submissions for Search a 2D Matrix.
     */
    fun searchMatrixUsingBinarySearch(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }
        var left = 0
        var right = matrix.lastIndex
        var mid: Int
        while (right - left > 1) {
            mid = left + (right - left) / 2
            when {
                matrix[mid][0] == target -> {
                    return true
                }
                matrix[mid][0] < target -> {
                    left = mid
                }
                else -> {
                    right = mid
                }
            }
        }
        return when {
            matrix[right][0] == target -> {
                true
            }
            matrix[right][0] < target -> {
                matrix[right].binarySearch(target) >= 0
            }
            else -> {
                matrix[left].binarySearch(target) >= 0
            }
        }
    }
}