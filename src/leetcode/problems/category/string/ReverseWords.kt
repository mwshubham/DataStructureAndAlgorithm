package leetcode.problems.category.string

import java.lang.StringBuilder

// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3391/
// https://leetcode.com/submissions/detail/367050157/?from=/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3391/
class ReverseWords {
    fun reverseWords(s: String): String {
        val sb = StringBuilder()
        var firstCharFound = false
        var spaceStarted = false
        s.forEach {
            if (it == ' ') {
                spaceStarted = true
            } else {
                if (!firstCharFound) {
                    firstCharFound = true
                    sb.append(it)
                } else if (spaceStarted) {
                    sb.append(" ")
                    sb.append(it)
                } else {
                    sb.append(it)
                }
                spaceStarted = false
            }
        }
        println(sb.toString())
        return sb.split(" ").reversed().joinToString(" ")
    }
}