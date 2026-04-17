package leetcode.problems.difficulty.medium

import java.util.Stack

/**
 * 2390. Removing stars from a string
 */
class RemovingStarsFromString {
    fun removeStars(s: String): String {
        if (s.isEmpty()) return s
        if (s.length == 1 && s != "*") return s

        val stack = Stack<Char>()
        val result = Stack<Char>()
        s.forEach {
            stack.push(it)
        }
        var count = 0
        while (stack.isNotEmpty()) {
            if (stack.peek() == '*') {
                count++
                stack.pop()
            } else {
                if (count == 0) {
                    result.push(stack.pop())
                } else {
                    stack.pop()
                    count--
                }
            }
        }
        val sb = StringBuilder()
        while (result.isNotEmpty()) {
            sb.append(result.pop())
        }
        return sb.toString()
    }

    fun removeStars2(s: String): String {
        if (s.isEmpty()) return s
        if (s.length == 1 && s != "*") return s

        val sb = StringBuilder()

        for (i in s) {
            if (i != '*') {
                sb.append(i)
            } else if (sb.isNotEmpty()) {
                sb.deleteCharAt(sb.length - 1)
            }
        }
        return sb.toString()
    }

}