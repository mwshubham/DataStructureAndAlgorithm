package leetcode.problems.category.string.easy

// https://leetcode.com/problems/increasing-decreasing-string/
class IncreasingDecreasingString {
    fun sortString(s: String): String {
        val result = StringBuilder()
        val count = IntArray(26)
        s.toCharArray().forEach {
            count[it - 'a']++
        }
        while (result.length < s.length) {
            for (i in 0..25) {
                if (count[i]-- > 0) result.append((i + 'a'.toInt()).toChar())
            }
            for (i in 0..25) {
                if (count[25 - i]-- > 0) result.append((25 - i + 'a'.toInt()).toChar())
            }
        }
        return result.toString()
    }
}