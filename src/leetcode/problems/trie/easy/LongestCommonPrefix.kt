package leetcode.problems.trie.easy

import kotlin1.println

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
//["flower","flow","flight"]
//["dog","racecar","car"]
//[]
//["", ""]
//["", "abc"]
//["abc", ""]
class LongestCommonPrefix {
    companion object {
        /**
         * Runtime: 168 ms, faster than 81.20% of Kotlin online submissions for Longest Common Prefix.
         * Memory Usage: 36.7 MB, less than 26.70% of Kotlin online submissions for Longest Common Prefix.
         */
        fun longestCommonPrefix(strs: Array<String>): String {
            if (strs.isEmpty() || strs[0].isEmpty()) return ""
            val pre = StringBuilder()
            strs[0].forEach {
                pre.append(it)
                for (j in 1..strs.lastIndex) {
                    if (strs[j].isEmpty()) return ""
                    if (strs[j].length < pre.length || strs[j][pre.lastIndex] != it) {
                        // one char less than saved one
                        return pre.substring(0, pre.lastIndex)
                    }
                }
            }
            // current prefix
            return pre.toString()
        }
    }
}

fun main() {
    LongestCommonPrefix.longestCommonPrefix(arrayOf("flower", "flow", "flight")).println()
}
