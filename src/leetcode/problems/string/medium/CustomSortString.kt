package leetcode.problems.string.medium

// https://leetcode.com/problems/custom-sort-string/
class CustomSortString {

    fun customSortString(S: String, T: String): String {
        val count = IntArray(26)
        for (c in T.toCharArray()) {
            count[c - 'a'] += 1
        }
        val sb = StringBuilder()
        for (c in S.toCharArray()) {
            while (count[c - 'a'] > 0) {
                count[c - 'a'] -= 1
                sb.append(c)
            }
        }
        (0..26).forEach {
            while (count[it] > 0) {
                count[it] -= 1
                sb.append('a' + it)
            }
        }
        return sb.toString()
    }

}