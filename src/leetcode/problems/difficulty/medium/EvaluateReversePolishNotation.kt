package leetcode.problems.difficulty.medium

import java.util.Stack

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/823/
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/1129549107/
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/1129549902/
 * https://leetcode.com/submissions/detail/1129550762/?from=explore&item_id=823
 */
class EvaluateReversePolishNotation {

    companion object {
        fun evalRPN(tokens: Array<String>): Int {
            val stack = Stack<Int>()
            tokens.forEach {
                when (it) {
                    "+" -> {
                        val first = stack.pop()
                        val second = stack.pop()
                        stack.push(second + first)
                    }

                    "-" -> {
                        val first = stack.pop()
                        val second = stack.pop()
                        stack.push(second - first)
                    }

                    "*" -> {
                        val first = stack.pop()
                        val second = stack.pop()
                        stack.push(second * first)
                    }

                    "/" -> {
                        val first = stack.pop()
                        val second = stack.pop()
                        stack.push(second / first)
                    }

                    else -> {
                        stack.push(it.toInt())
                    }
                }
            }
            return stack.pop()
        }
    }
}
