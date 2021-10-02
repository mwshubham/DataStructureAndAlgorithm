package leetcode.problems.category.string.medium

import kotlin1.println
import java.lang.Integer.max

/**
 * 38. Count and Say
 * https://leetcode.com/problems/count-and-say/
 */
class CountAndSay {
    companion object{
        fun countAndSay(n: Int): String {
            return countAndSay(n, "1")
        }

        private fun countAndSay(n: Int, str: String): String{
            if (n == 1) return str
            val sb = StringBuilder()
            var lastKnownChar = str[0]
            var count = 1
            for (i in 1..str.lastIndex) {
                val ch = str[i]
                if (lastKnownChar == ch) {
                    count++
                } else {
                    sb.append("${max(1, count)}")
                    sb.append("$lastKnownChar")
                    count = 1
                    lastKnownChar = ch
                }
            }
            sb.append("${max(1, count)}")
            sb.append("$lastKnownChar")
            return countAndSay(n-1, sb.toString())
        }
    }
}

fun main(){
//    CountAndSay.countAndSay(1).println()
//    CountAndSay.countAndSay(2).println()
//    CountAndSay.countAndSay(3).println()
//    CountAndSay.countAndSay(4).println()
    CountAndSay.countAndSay(5).println()
    CountAndSay.countAndSay(6).println()
//    CountAndSay.countAndSay(7).println()
//    CountAndSay.countAndSay(8).println()
//    CountAndSay.countAndSay(30).println()
}