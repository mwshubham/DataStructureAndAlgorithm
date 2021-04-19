package leetcode.problems.category.string.medium

// https://leetcode.com/problems/check-if-a-string-can-break-another-string/
class CheckIfCanBreak {

    fun checkIfCanBreak(s1: String, s2: String): Boolean {
        val n: Int = s1.length
        val arr = IntArray(26)
        val brr = IntArray(26)
        for (i in 0 until n) arr[(s1[i] - 97).toInt()]++
        for (i in 0 until n) brr[(s2[i] - 97).toInt()]++
        var count1 = 0
        var count2 = 0
        var f1 = false
        var f2 = false
        for (i in 0..25) {
            count1 += arr[i]
            count2 += brr[i]
            if (count1 > count2) {
                if (f2) return false
                f1 = true
            } else if (count2 > count1) {
                if (f1) return false
                f2 = true
            }
        }
        return true
    }
}
