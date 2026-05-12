package leetcode.problems.difficulty.easy

import kotlin1.println
import java.util.Stack
import kotlin.math.max

/**
 * 415. Add Strings
 */
class AddStrings {
    // 11, 123
    fun addStrings(num1: String, num2: String): String {
        val stack = Stack<Int>()
        val l1 = num1.length
        val l2 = num2.length
        var carry = 0
        repeat(max(l1, l2)) {
            val sum = (num1.getOrNull(l1 - it - 1)?.digitToInt() ?: 0)
                .plus(num2.getOrNull(l2 - it - 1)?.digitToInt() ?: 0)
                .plus(carry)
            carry = sum / 10
            stack.push(sum % 10)
        }
        val res = StringBuilder()
        if (carry != 0) res.append(carry)
        while (stack.isNotEmpty()) {
            res.append(stack.pop())
        }
        return res.toString()
    }

    fun addStrings2(num1: String, num2: String): String {
        val res = StringBuilder()
        val l1 = num1.length
        val l2 = num2.length
        var carry = 0
        repeat(max(l1, l2)) {
            val sum = (num1.getOrNull(l1 - it - 1)?.digitToInt() ?: 0)
                .plus(num2.getOrNull(l2 - it - 1)?.digitToInt() ?: 0)
                .plus(carry)
            carry = sum / 10
            res.append(sum % 10)
        }
        if (carry != 0) res.append(carry)
        return res.reverse().toString()
    }
}

fun main() {
    AddStrings().apply {
        addStrings("11", "123").println()
    }
}