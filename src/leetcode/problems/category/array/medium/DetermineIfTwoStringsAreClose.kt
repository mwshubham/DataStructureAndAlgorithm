package leetcode.problems.category.array.medium

import kotlin1.println

/**
 * 1657. Determine if two strings are close
 */
class DetermineIfTwoStringsAreClose {

    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false
        val w1Arr = Array(26) { 0 }
        val w2Arr = Array(26) { 0 }
        word1.forEach { c ->
            w1Arr[c - 'a']++
        }
        word2.forEach { c ->
            w2Arr[c - 'a']++
        }
        repeat(26) {
            if ((w1Arr[it] != 0 && w2Arr[it] == 0)
                || (w1Arr[it] == 0 && w2Arr[it] != 0)
            ) {
                return false
            }
        }
        w1Arr.sortWith { a, b -> b - a }
        w2Arr.sortWith { a, b -> b - a }
        println(w1Arr.contentToString())
        println(w2Arr.contentToString())
        var i = 0
        while (i < 26) {
            if (w1Arr[i] != w2Arr[i]) {
                return false
            }
            if (w1Arr[i] == 0 && w2Arr[i] == 0) {
                return true
            }
            i++
        }
        return true
    }
}

fun main() {
    DetermineIfTwoStringsAreClose().apply {
//        closeStrings("abc", "bca").println()
//        closeStrings("uau", "ssx").println()
        closeStrings("abbzzca", "babzzcz").println()
    }
}