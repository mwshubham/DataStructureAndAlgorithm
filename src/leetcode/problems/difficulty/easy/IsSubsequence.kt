package leetcode.problems.difficulty.easy

/**
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence
 */
class IsSubsequence {

    fun isSubsequence(s: String, t: String): Boolean {
        var start = 0

        t.forEach {
            if (start == s.length) {
                return true
            }
            if (s[start] == it) {
                start++
            }
        }
        if (start == s.length) {
            return true
        }

        return false
    }
}