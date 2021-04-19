package leetcode.problems.category.math.easy

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/
class LongestPalindrome {

    fun longestPalindrome(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1) return 1
        var result = 0
        val intArray = IntArray(26 * 2)
        s.forEach {
            if (it.isUpperCase()) {
                intArray[26 + (it - 'A')]++
            } else {
                intArray[it - 'a']++
            }
        }
        var hasSingle = false
        intArray.forEach {
            if (it % 2 == 0) {
                result += it
            } else {
                result += it - 1
                hasSingle = true
            }
        }
        if (hasSingle) {
            result++
        }

        println(intArray.asList())
        return result
    }
}

fun main() {
    val instance = LongestPalindrome()
    instance.longestPalindrome("abccccdd")
}