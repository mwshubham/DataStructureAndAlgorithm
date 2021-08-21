package leetcode.problems.category.array.medium

/**
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 */
class ValidSudoku {
    /**
     * Runtime: 196 ms, faster than 80.38% of Kotlin online submissions for Valid Sudoku.
     * Memory Usage: 41.8 MB, less than 51.90% of Kotlin online submissions for Valid Sudoku.
     */
    companion object{
        fun isValidSudoku(board: Array<CharArray>): Boolean {
            val seen = HashSet<String>()
            for (i in 0..8){
                for (j in 0..8){
                    val number = board[i][j]
                    if (number != '.'){
                        if (
                            !seen.add("$number in row $i")
                            || !seen.add("$number in colm $j")
                            || !seen.add("$number in block ${i/3}-${j/3}")
                        ){
                            return false
                        }
                    }
                }
            }
            return true
        }
    }
}