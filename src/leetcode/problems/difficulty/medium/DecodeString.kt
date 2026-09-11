package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.Stack

/**
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/description
 */
class DecodeString {

    fun decodeString(s: String): String {
        val stack = Stack<Any>()
        var index = 0
        val sb = StringBuilder()
        val queue = Stack<String>()
        while (index <= s.lastIndex) {
            when {
                s[index].isDigit() -> {
                    sb.clear()
                    while (index <= s.lastIndex && s[index].isDigit()) {
                        sb.append(s[index++])
                    }
                    stack.push(sb.toString().toInt())
                }

                s[index].isLowerCase() -> {
                    sb.clear()
                    while (index <= s.lastIndex && s[index].isLowerCase()) {
                        sb.append(s[index++])
                    }
                    stack.push(sb.toString())
                }

                s[index] == ']' -> {
                    queue.clear()
                    while (stack.peek() is String) {
                        queue.push(stack.pop().toString())
                    }
                    val times = stack.pop() as Int
                    sb.clear()
                    repeat(times) {
                        queue.forEach {
                            sb.append(it)
                        }
                    }
                    stack.push(sb.toString())
                    index++
                }

                else -> index++
            }
            // Merge consecutive strings
            if (stack.isNotEmpty() && stack.peek() is String) {
                val current = stack.pop() as String

                if (stack.isNotEmpty() && stack.peek() is String) {
                    val previous = stack.pop() as String
                    stack.push(previous + current)
                } else {
                    stack.push(current)
                }
            }
        }
        return stack.joinToString("")
    }

    fun decodeString2(s: String): String {
        val counts = ArrayDeque<Int>()
        val strings = ArrayDeque<String>()

        var current = StringBuilder()
        var number = 0
        for (ch in s) {
            when {
                ch.isDigit() -> {
                    number = number * 10 + (ch - '0')
                }

                ch == '[' -> {
                    counts.addLast(number)
                    strings.addLast(current.toString())
                    number = 0
                    current = StringBuilder()
                }

                ch == ']' -> {
                    val result = StringBuilder(strings.removeLast())
                    repeat(counts.removeLast()) {
                        result.append(current)
                    }
                    current = result
                }

                else -> current.append(ch)
            }
        }
        return current.toString()
    }
}

fun main() {
    DecodeString().apply {
//        decodeString("3[a]2[bc]").println()
//        decodeString("3[a2[c]]").println()
//        decodeString("2[abc]3[cd]ef").println()
        decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef").println()
    }
}
