package leetcode.problems.difficulty.medium

import kotlin1.println
import java.lang.IllegalStateException

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/797/
 */
class WordSearch {
    companion object {
        fun exist(board: Array<CharArray>, word: String): Boolean {
            if (word.isEmpty()) return true
            if (board.isEmpty() || board.first().isEmpty()) return false
            for (row in 0..board.lastIndex) {
                for (col in 0..board.first().lastIndex) {
                    if (exist(board, row, col, word, 0)) {
                        return true
                    }
                }
            }
            return false
        }

        private fun exist(board: Array<CharArray>, row: Int, col: Int, word: String, index: Int): Boolean {
            if (index == word.length) return true
            if (row < 0 || row > board.lastIndex || col < 0 || col > board.first().lastIndex) return false
            if (board[row][col] != word[index]) return false
            board[row][col] = board[row][col].plus(256)
            val res =
                exist(board, row, col - 1, word, index + 1) ||
                        exist(board, row - 1, col, word, index + 1) ||
                        exist(board, row, col + 1, word, index + 1) ||
                        exist(board, row + 1, col, word, index + 1)
            board[row][col] = board[row][col].minus(256)
            return res
        }
    }
}

fun main() {
    WordSearch.exist(
        board = Array(3) {
            when (it) {
                0 -> charArrayOf('A', 'B', 'C', 'E')
                1 -> charArrayOf('S', 'F', 'C', 'S')
                2 -> charArrayOf('A', 'D', 'E', 'E')
                else -> {
                    throw IllegalStateException()
                }
            }
        },
//        "ABCB"
        word = "ABFDEC"
    ).println()
}