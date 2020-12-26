package leetcode.problems.stack.easy

import java.util.*

/**
 * Runtime: 140 ms, faster than 86.47% of Kotlin online submissions for Valid Parentheses.
 * Memory Usage: 33.6 MB, less than 63.37% of Kotlin online submissions for Valid Parentheses.
 */
class ValidParentheses {

    companion object {
        private val brackets = mutableMapOf<Char, Char>().apply {
            put('(', ')')
            put('{', '}')
            put('[', ']')
        }

        private fun isOpeningBracket(char: Char) = brackets.containsKey(char)
        fun isClosingBracket(char: Char) = !isOpeningBracket(char)
    }

    fun isValid(s: String): Boolean {
        if (s.isEmpty()) return true
        if (s.length % 2 != 0) return false
        val stackA = Stack<Char>().apply {
            s.forEach { push(it) }
        }
        val stackB = Stack<Char>()
        while (stackA.isNotEmpty()) {
            with(stackA.pop()) {
                if (isClosingBracket(this)) {
                    stackB.push(this)
                    return@with
                } else {
                    if (stackB.isEmpty()) return false
                    if (stackB.pop() != brackets[this]) return false
                }
            }
        }
        return stackA.isEmpty() && stackB.isEmpty()
    }

    /**
     * Result are not correct and deviates for each run
     * Using single stack
     * Runtime: 136 ms, faster than 91.09% of Kotlin online submissions for Valid Parentheses.
     * Memory Usage: 35.2 MB, less than 14.52% of Kotlin online submissions for Valid Parentheses.
     */
    fun isValid2(s: String): Boolean {
        if (s.isEmpty()) return true
        var index = s.lastIndex
        val stackB = Stack<Char>()
        while (index != -1) {
            with(s[index--]) {
                if (isClosingBracket(this)) {
                    stackB.push(this)
                    return@with
                } else {
                    if (stackB.isEmpty()) return false
                    if (stackB.pop() != brackets[this]) return false
                }
            }
        }
        return stackB.isEmpty()
    }
}