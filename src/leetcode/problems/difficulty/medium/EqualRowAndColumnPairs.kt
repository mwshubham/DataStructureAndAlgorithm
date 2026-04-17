package leetcode.problems.difficulty.medium

/**
 * 2352. Equal row and column pairs
 */
class EqualRowAndColumnPairs {

    fun equalPairs(grid: Array<IntArray>): Int {
        val rows = grid.size
        val columns = grid[0].size
        val rHashArr = Array(rows) { 0 }
        val cHashArr = Array(columns) { 0 }
        for (row in 0..(rows - 1)) {
            for (col in 0..(columns - 1)) {
                rHashArr[row] = rHashArr[row] * 11 + grid[row][col]
                cHashArr[col] = cHashArr[col] * 11 + grid[row][col]
            }
        }

        var result = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (rHashArr[i] == cHashArr[j]) {
                    result++
                }
            }
        }
        return result
    }

    fun equalPairs2(grid: Array<IntArray>): Int {
        val rowMap = HashMap<String, Int>()
        val colMap = HashMap<String, Int>()
        val rows = grid.size
        val columns = grid[0].size

        for (row in 0..(rows - 1)) {
            val rSb = StringBuilder()
            for (col in 0..(columns - 1)) {
                rSb.append(grid[row][col])
                rSb.append(" ")
            }
            val rStr = rSb.toString()
            rowMap[rStr] = rowMap.getOrDefault(rStr, 0) + 1
        }
        for (col in 0..(columns - 1)) {
            val cSb = StringBuilder()
            for (row in 0..(rows - 1)) {
                cSb.append(grid[row][col])
                cSb.append(" ")
            }
            val cStr = cSb.toString()
            colMap[cStr] = colMap.getOrDefault(cStr, 0) + 1
        }
        var count = 0
        rowMap.forEach { rStr, i ->
            count += colMap.getOrDefault(rStr, 0) * rowMap.getOrDefault(rStr, 0)
        }
        return count
    }
}

fun main() {
    EqualRowAndColumnPairs().apply {
        equalPairs(
            arrayOf(
                intArrayOf(3, 2, 1),
                intArrayOf(1, 7, 6),
                intArrayOf(2, 7, 7),
            )
        )
    }
}