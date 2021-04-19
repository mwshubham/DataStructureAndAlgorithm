package leetcode.problems.category.string.medium


class MinStepsToAnagram {

    fun minSteps(s: String, t: String): Int {
        val count = IntArray(26)
        for (i in s.indices) {
            ++count[s[i] - 'a'] // count the occurrences of chars in s.
            --count[t[i] - 'a'] // compute the difference between s and t.
        }
        var res = 0
        count.forEach {
            if (it > 0) {
                res += it
            }
        }
        return res
    }
}