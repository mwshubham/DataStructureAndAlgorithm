package leetcode.challenge.december

/**
 * https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3580/
 * https://leetcode.com/submissions/detail/437058954/?from=explore&item_id=3580
 *
 * Runtime: 264 ms, faster than 96.51% of Kotlin online submissions for Diagonal Traverse.
 * Memory Usage: 38.3 MB, less than 96.51% of Kotlin online submissions for Diagonal Traverse.
 */

//[[]]
//[[1], [2], [3]]
//[[1, 2, 3]]
//[[1,2,3],[4,5,6],[7,8,9]]
//[[1,2,3],[4,5,6]]
//[[1,2],[3,4],[5,6]]
class DiagonalTraverse {
    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty()) return IntArray(0)
        var rows = matrix.size
        var cols = matrix[0].size

        // single row
        if (rows == 1) {
            return matrix[0]
        }

        // single column
        if (cols == 1) {
            return IntArray(rows) {
                matrix[it][0]
            }
        }

        val output = IntArray(rows * cols)

        val size = rows * cols
        // mapping rows cols to 0th based index
        rows--
        cols--

        var index = 0
        output[index++] = matrix[0][0]

        var row = 0
        var col = 0

        while (index < size) {
            // can go front straight
            println("can go front straight or go down")
            if (col < cols) {
                col++
            } else {
                row++
            }
            println(output.asList())
            println("row: $row")
            println("col: $col")
            println("")
            println("")

            // go down diagonally
            println("go down diagonally")
            while (true) {
                output[index++] = matrix[row][col]
                if (row + 1 > rows || col - 1 < 0) {
                    break
                } else {
                    row++
                    col--
                }
            }
            println(output.asList())
            println("row: $row")
            println("col: $col")
            println("")
            println("")


            // can go down straight
            println("can go down straight or go front")
            if (row < rows) {
                row++
            } else {
                col++
            }
            println(output.asList())
            println("row: $row")
            println("col: $col")
            println("")
            println("")


            // go up diagonally
            println("go up diagonally")
            while (true) {
                if (index >= size) {
                    break
                }
                output[index++] = matrix[row][col]
                if (row - 1 < 0 || col + 1 > cols) {
                    break
                } else {
                    row--
                    col++
                }
            }
            println(output.asList())
            println("index: $index")
            println("row: $row")
            println("col: $col")
            println("")
            println("")
        }
        return output
    }
}