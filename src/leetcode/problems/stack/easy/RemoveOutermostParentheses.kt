package leetcode.problems.stack.easy

// https://leetcode.com/problems/remove-outermost-parentheses/
class RemoveOutermostParentheses {
//    fun removeOuterParentheses(S: String): String {
//        val stack = Stack<Char>()
//        val stringBuilder = StringBuilder()
//        var openBracketCounter = 0
//        var closeBracketCounter = 0
//        val outputStack = Stack<Char>()
//        S.forEach {
//            if (it == '(') {
//                openBracketCounter++
//            } else {
//                closeBracketCounter++
//            }
//            stack.push(it)
//            if (openBracketCounter == closeBracketCounter) {
//                for (index in 1 until stack.lastIndex) {
//                    stringBuilder.append(stack[index])
//                }
//                stack.clear()
//            }
//        }
//        return stringBuilder.toString()
//    }

    /**
     * Without stack
     * Runtime: 176 ms, faster than 90.70% of Kotlin online submissions for Remove Outermost Parentheses.
     * Memory Usage: 33.7 MB, less than 100.00% of Kotlin online submissions for Remove Outermost Parentheses.
     */
    fun removeOuterParentheses(S: String): String {
        val sb = StringBuilder()
        var counter = 0
        var start = 0
        for (index in S.indices) {
            if (S[index] == '(') {
                counter++
            } else {
                counter--
            }
            if (counter == 0) {
                sb.append(S.substring(start + 1, index))
                start = index + 1
            }
        }
        return sb.toString()
    }
}