package leetcode.challenge.april

import kotlin1.println

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3720/
 *
 * https://leetcode.com/submissions/detail/484963001/?from=explore&item_id=3720
 */
class RotateImage {
    companion object {
        /**
         * The idea was firstly transpose the matrix and then flip it symmetrically.
         *
         * Runtime: 164 ms, faster than 84.81% of Kotlin online submissions for Rotate Image.
         * Memory Usage: 35.5 MB, less than 36.08% of Kotlin online submissions for Rotate Image.
         */
        fun rotate(matrix: Array<IntArray>) {
            for (i in matrix.indices) {
                for (j in i until matrix[0].size) {
                    var temp = 0
                    temp = matrix[i][j]
                    matrix[i][j] = matrix[j][i]
                    matrix[j][i] = temp
                }
            }
            for (i in matrix.indices) {
                for (j in 0 until matrix.size / 2) {
                    var temp = 0
                    temp = matrix[i][j]
                    matrix[i][j] = matrix[i][matrix.size - 1 - j]
                    matrix[i][matrix.size - 1 - j] = temp
                }
            }
        }
    }
}

@Suppress("UNUSED_CHANGED_VALUE")
fun main() {
    RotateImage.rotate(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    )

    var i = 1
    RotateImage.rotate(
        arrayOf(
            intArrayOf(i++, i++, i++, i++),
            intArrayOf(i++, i++, i++, i++),
            intArrayOf(i++, i++, i++, i++),
            intArrayOf(i++, i++, i++, i++)
        )
    )
}