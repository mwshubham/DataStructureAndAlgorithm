package hackerrank

import kotlin1.println

class ConnectedCellsInAGrid {

    fun connectedCell(matrix: Array<Array<Int>>): Int {
        var maxArea = 0
        for (i in 0..matrix.lastIndex) {
            for (j in 0..matrix[0].lastIndex) {
                if (matrix[i][j] == 1) {
                    maxArea = Math.max(connectedCell(matrix, i, j), maxArea)
                }
            }
        }
        return maxArea
    }

    fun connectedCell(matrix: Array<Array<Int>>, row: Int, col: Int): Int {
        if (row < 0) return 0
        if (row > matrix.lastIndex) return 0
        if (col < 0) return 0
        if (col > matrix[0].lastIndex) return 0
        if (matrix[row][col] == 2 || matrix[row][col] == 0) return 0
        matrix[row][col] = 2
        return 1 + connectedCell(
            matrix = matrix,
            row = row,
            col = col + 1
        ) + connectedCell(
            matrix = matrix,
            row = row + 1,
            col = col
        ) + connectedCell(
            matrix = matrix,
            row = row,
            col = col - 1
        ) + connectedCell(
            matrix = matrix,
            row = row - 1,
            col = col
        ) + connectedCell(
            matrix = matrix,
            row = row - 1,
            col = col - 1
        ) + connectedCell(
            matrix = matrix,
            row = row + 1,
            col = col + 1
        )+ connectedCell(
            matrix = matrix,
            row = row + 1,
            col = col - 1
        ) + connectedCell(
            matrix = matrix,
            row = row - 1,
            col = col + 1
        )
    }
}

fun main() {
    ConnectedCellsInAGrid().connectedCell(
        arrayOf(
            arrayOf(0, 1, 1, 1, 1),
            arrayOf(1, 0, 0, 0, 1),
            arrayOf(1, 1, 0, 1, 0),
            arrayOf(0, 1, 0, 1, 1),
            arrayOf(0, 1, 1, 1, 0)
        )
    ).println()
}