package leetcode.problems.stack.easy

import java.util.*

// https://leetcode.com/problems/make-the-string-great/
/**
 * Runtime: 168 ms, faster than 95.83% of Kotlin online submissions for Make The String Great.
 * Memory Usage: 33.8 MB, less than 89.58% of Kotlin online submissions for Make The String Great.
 */
class MakeTheStringGreat {
    fun makeGood(s: String): String {
        val stack = Stack<Char>()
        s.forEach {
            if (stack.isNotEmpty() && Math.abs(stack.peek()!!.toInt() - it.toInt()) == 32)
                stack.pop()
            else stack.push(it)
        }
        val res = CharArray(stack.size)
        var index = stack.size - 1
        while (!stack.isEmpty()) {
            res[index--] = stack.pop()!!
        }
        return String(res)
    }
}