package leetcode.problems

class MatrixDiagonalSum {
    /**
     * Runtime: 176 ms, faster than 100.00% of Kotlin online submissions for Matrix Diagonal Sum.
     */
    fun diagonalSum(mat: Array<IntArray>): Int {
        var res = 0
        val n = mat.size
        for (i in 0 until n) {
            res += mat[i][i] // Primary diagonals are row = column!
            res += mat[n - 1 - i][i] // Secondary diagonals are row + column = n-1!
        }
        return if (n % 2 == 0) res else res - mat[n / 2][n / 2] // if n is a odd number, that mean we have added the center element twice!
    }
}