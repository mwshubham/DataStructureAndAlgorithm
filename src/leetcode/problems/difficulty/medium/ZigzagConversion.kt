package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.LinkedList

/**
 * 6. Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/description/
 * Beats: 78.28%
 *
 * Time Complexity: O(N)
 *
 * Space Complexity: O(N)
 */
class ZigzagConversion {
    companion object {
        fun convert(s: String, numRows: Int): String {
            if (s.length <= numRows) return s
            if (numRows == 1) return s
            val rows = Array<LinkedList<Char>>(numRows) { LinkedList() }
            var goingDown = true
            var rowIndex = 0
            repeat(s.length) {
                rows[rowIndex].add(s[it])
                if (goingDown) {
                    if (rowIndex == numRows - 1) {
                        rowIndex--
                        goingDown = false
                    } else {
                        rowIndex++
                    }
                } else {
                    if (rowIndex == 0) {
                        rowIndex++
                        goingDown = true
                    } else {
                        rowIndex--
                    }
                }
            }
            return StringBuilder().apply {
                rows.forEach {
                    it.forEach {
                        append(it)
                    }
                }
            }.toString()
        }
    }
}


fun main() {
//    ZigzagConversion.convert("PAYPALISHIRING", 3).println()
    ZigzagConversion.convert("AB", 1).println()
}