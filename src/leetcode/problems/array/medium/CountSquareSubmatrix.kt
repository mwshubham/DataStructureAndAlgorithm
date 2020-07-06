package leetcode.problems.array.medium

// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/
// https://leetcode.com/submissions/detail/342871202/?from=/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/
class CountSquareSubmatrix {

    fun countSquares(matrix: Array<IntArray>): Int {
//        matrix.forEachIndexed { index, array ->
//            println("image[$index]: ${array.joinToString()}")
//        }

        val rowCount = matrix.size
        if (rowCount <= 0) return 0

        val columnSize = matrix[0].size
        if (columnSize <= 0) return 0

        val dp = Array(rowCount + 1) { IntArray(columnSize + 1) }
        var count = 0
        for (rowIndex in 1..rowCount) {
            for (columnIndex in 1..columnSize) {
                if (matrix[rowIndex - 1][columnIndex - 1] == 1) {
                    val edgeSize =
                        dp[rowIndex - 1][columnIndex - 1].coerceAtMost(dp[rowIndex - 1][columnIndex].coerceAtMost(dp[rowIndex][columnIndex - 1])) + 1
                    count += (edgeSize - 1 + 1)
                    dp[rowIndex][columnIndex] = edgeSize
                }
            }
        }
        return count
    }
}

fun main() {
    val instance = CountSquareSubmatrix()
    println(
        instance.countSquares(
            arrayOf(
                intArrayOf(0, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(0, 1, 1, 1)
            )
        )
    )
}