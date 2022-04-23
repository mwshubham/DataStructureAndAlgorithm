package leetcode.problems.difficulty.hard

/**
 * https://leetcode.com/problems/sudoku-solver/
 * 37. Sudoku Solver
 */
class SudokuSolver {

    fun solveSudoku(board: Array<CharArray>) {
        if (board.isEmpty()) return
        board.forEach {
            println(it.asList())
        }
        println("---------------")
        solve(board)
        board.forEach {
            println(it.asList())
        }
    }

    fun solve(board: Array<CharArray>): Boolean {
        for (i in board.indices) {
            for (j in board.first().indices) {
                var ch = '0'
                if (board[i][j] == '.') {
                    repeat (9) {
                        ch += 1
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch
                            if (solve(board)) {
                                return true
                            } else {
                                // rollback.
                                board[i][j] = '.'
                            }
                        }
                    }
                    // if all case failed
                    return false
                }
            }
        }
        return true
    }

    fun isValid(board: Array<CharArray>, row: Int, col: Int, ch: Char): Boolean {
        for (i in 0..8) {
            if (board[i][col] != '.' && board[i][col] == ch) return false
            if (board[row][i] != '.' && board[row][i] == ch) return false
            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] != '.'
                && board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == ch
            ) return false
        }
        return true
    }
}

fun main() {
    SudokuSolver().apply {
        solveSudoku(
            arrayOf(
                charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
            )
        )
    }
}