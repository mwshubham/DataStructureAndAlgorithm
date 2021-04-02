package leetcode.problems.stack.medium

import java.util.*

/**
 * https://leetcode.com/problems/remove-k-digits/
 */
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
// https://leetcode.com/submissions/detail/339131847/?from=/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
class RemoveKDigitMakeSmallNumber {

    /**
     * Runtime: 220 ms, faster than 42.86% of Kotlin online submissions for Remove K Digits.
     * Memory Usage: 36.6 MB, less than 42.86% of Kotlin online submissions for Remove K Digits.
     */
    @Suppress("SpellCheckingInspection")
    fun removeKdigits(num: String, k: Int): String {
        if (num.length == k) return "0"
        if (k == 0) return num

        val strBuilder = StringBuilder(num)
        for (times in 0 until k) {
//            println("times: $times")
            var i = 0
            while (i < strBuilder.lastIndex && strBuilder[i] <= strBuilder[i + 1]) {
                i++
            }
            strBuilder.delete(i, i + 1)
        }
        return mapOutput(strBuilder.toString().trimStart('0'))
    }

    private fun mapOutput(input: String) = if (input.isEmpty()) "0" else input


    fun removeKDigitsUsingStack(num: String, k: Int): String {
        val stack = Stack<Char>()
        var K = k
        num.forEach { char ->
            while (stack.isNotEmpty() && K > 0 && stack.peek() > char) {
                stack.pop()
                K -= 1
            }

            // If stack has some number
            // Skip first '0' leading zero
            if (stack.isNotEmpty() || char != '0') {
                stack.push(char)
            }
        }


        // Remove largest values from top of the stack
        while (stack.isNotEmpty() && K > 0) {
            stack.pop()
            K -= 1
        }

        if (stack.isEmpty()) return "0"
        return stack.joinToString("")
    }
}

fun main() {
    val instance = RemoveKDigitMakeSmallNumber()

    println(instance.removeKDigitsUsingStack("1432219", 3)) // 1219
    println(instance.removeKDigitsUsingStack("10200", 1)) // 200
    println(instance.removeKDigitsUsingStack("10", 2)) // 0
    println(instance.removeKDigitsUsingStack("10", 1)) // 0
}