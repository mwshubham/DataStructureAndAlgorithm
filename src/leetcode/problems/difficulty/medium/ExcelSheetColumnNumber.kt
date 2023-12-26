package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 171. Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 *
 * https://leetcode.com/problems/excel-sheet-column-number/submissions/1128812590/
 * https://leetcode.com/problems/excel-sheet-column-number/submissions/1128815098/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/817/
 * https://leetcode.com/submissions/detail/1128815316/?from=explore&item_id=817
 */
class ExcelSheetColumnNumber {
    companion object {
        fun titleToNumber(columnTitle: String): Int {
            var num = 0
            columnTitle.forEachIndexed { index, char ->
                num += (char - 'A' + 1) * 26.pow(columnTitle.lastIndex - index)
            }
            return num
        }

        private fun Int.pow(power: Int): Int {
            var result = 1
            for (i in 0 until power) {
                result *= this
            }

            return result
        }
    }

}

fun main() {
    ExcelSheetColumnNumber.titleToNumber("A").println()
    ExcelSheetColumnNumber.titleToNumber("B").println()
    ExcelSheetColumnNumber.titleToNumber("AA").println()
    ExcelSheetColumnNumber.titleToNumber("AB").println()
    ExcelSheetColumnNumber.titleToNumber("ZY").println()
    ExcelSheetColumnNumber.titleToNumber("ZZ").println()
    ExcelSheetColumnNumber.titleToNumber("AAA").println()
}