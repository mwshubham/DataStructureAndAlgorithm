package leetcode.contest

import kotlin1.println
import java.lang.StringBuilder


/**
 * 1849. Splitting a String Into Descending Consecutive Values
 * https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/
 */
//"10"
//"1234"
//"050043"
//"9080701"
//"10009998"
//"59376699145"
//"200100"
//"1000"
//"99999999999999999999"
//"4771447713"
class SplittingAStringIntoDescendingConsecutiveValues {
    companion object {
        fun splitString(s: String): Boolean {
            for (i in 0..s.lastIndex) {
                // end is exclusive thus plus 1
                val prev = s.substring(0, i + 1)
                var requiredDifference = 1L

                val current = StringBuilder()
                var j = i + 1
                while (j <= s.lastIndex) {
                    current.append(s[j])

                    if (current.toString().toLong() == 0L) {
                        while (j < s.lastIndex && s[j + 1] == '0') {
                            j++
                        }
                    }

                    if (prev.length > current.length + 2) {
                        j++
                        continue
                    }

                    if (current.toString().toLong() >= prev.toLong()) break
                    val diff = prev.toLong() - current.toString().toLong()

                    if (diff == requiredDifference) {
                        requiredDifference++
                        current.clear()
                        if (j == s.lastIndex) {
                            return true
                        }
                    }
                    j++
                }
            }
            return false
        }
    }
}


fun main() {
    SplittingAStringIntoDescendingConsecutiveValues.splitString("4771447713").println()
}