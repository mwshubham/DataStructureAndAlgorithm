package leetcode.challenge.april

import java.util.*
import kotlin.math.max

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3695/
 * https://leetcode.com/submissions/detail/475850513/?from=explore&item_id=3695
 */
class LongestValidParentheses {
    //    "(()"
    //    ")()())"
    //    ""
    //    "()())((()))"
    //    "()(()"
    companion object {
        /**
         * https://leetcode.com/submissions/detail/475850513/?from=explore&item_id=3695
         *
         * Runtime: 188 ms, faster than 46.94% of Kotlin online submissions for Longest Valid Parentheses.
         * Memory Usage: 35.2 MB, less than 81.63% of Kotlin online submissions for Longest Valid Parentheses.
         *
         * Your runtime beats 61.22 % of kotlin submissions.
         * Your memory usage beats 40.82 % of kotlin submissions
         */
        fun longestValidParentheses(s: String): Int {
            val stack = Stack<Int>()
            s.forEachIndexed { index, it ->
                if (it == '(') {
                    stack.push(index)
                } else {
                    when {
                        stack.isEmpty() -> {
                            stack.push(index)
                        }
                        s[stack.peek()] == '(' -> {
                            stack.pop()
                        }
                        else -> {
                            stack.push(index)
                        }
                    }
                }
            }
            var longest = 0
            if (stack.isEmpty()) return s.length
            else {
                var max = s.length - 1
                while (stack.isNotEmpty()) {
                    val top = stack.pop()
                    longest = max(longest, max(max - top, top - if (stack.isEmpty()) 0 else stack.peek()))
                    if (longest % 2 != 0) longest--
                    max = top
                }
            }
            return longest
        }
    }
}

fun main() {
//    LongestValidParentheses.longestValidParentheses("())").println()
//    LongestValidParentheses.longestValidParentheses("").println()
//    LongestValidParentheses.longestValidParentheses("(").println()
//    LongestValidParentheses.longestValidParentheses(")()())").println()
//    LongestValidParentheses.longestValidParentheses("()()").println()
//    LongestValidParentheses.longestValidParentheses("(())").println()
}






