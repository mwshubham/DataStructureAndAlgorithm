package leetcode.problems.category.string.medium

import java.util.*

// https://leetcode.com/problems/find-and-replace-pattern/
class FindAndReplacePattern {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val res = LinkedList<String>()
        for (w in words) {
            val p = IntArray(26)
            val s = IntArray(26)
            var same = true
            for (i in w.indices) {
                if (s[w[i] - 'a'] != p[pattern[i] - 'a']) {
                    same = false
                    break
                } else {
                    p[pattern[i] - 'a'] = i + 1
                    s[w[i] - 'a'] = p[pattern[i] - 'a']
                }
            }
            if (same) res.add(w)
        }
        return res
    }


}

//["a","b","c"]
//"a"

//["abc","deq","mee","aqq","dkd","ccc"]
//"abb"

fun main() {
    println(
        FindAndReplacePattern().findAndReplacePattern(
            arrayOf(
                "aqq"
            ),
            "abb"
        )
    )
}