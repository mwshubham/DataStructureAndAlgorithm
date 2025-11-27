package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.*

class ValidParenthesisString {
    companion object {
        fun checkValidString(s: String): Boolean {
            val charOpen = Stack<Int>()
            val wildcard = Stack<Int>()

            s.forEachIndexed { index, char ->
                when (char) {
                    '(' -> {
                        charOpen.push(index)
                    }

                    '*' -> {
                        wildcard.push(index)
                    }

                    ')' -> {
                        if (charOpen.isNotEmpty()) {
                            charOpen.pop()
                        } else if (wildcard.isNotEmpty()) {
                            wildcard.pop()
                        } else {
                            return false
                        }
                    }
                }
            }

            while (charOpen.isNotEmpty()) {
                if (wildcard.isEmpty()) return false
                if (charOpen.pop() > wildcard.pop()) return false
            }
            return true
        }

        fun checkValidString2(s: String): Boolean {
            val list = LinkedList<Int>()

            s.forEachIndexed { charIndex, char ->
                println("charIndex: $charIndex ---- char: $char")
                if (charIndex == 0) {
                    when (char) {
                        '(' -> {
                            list.add(-1)
                        }

                        '*' -> {
                            list.add(-1)
                            list.add(0)
                            list.add(1)
                        }

                        ')' -> {
                            return false
                        }
                    }
                } else {
                    when (char) {
                        '(' -> {
                            list.forEachIndexed { index, item ->
                                list[index] = item - 1
                            }
                        }

                        '*' -> {
                            list.add(0, list.first() - 1)
                            list.add(list.size, list.last() + 1)
                        }

                        ')' -> {
                            list.forEachIndexed { index, item ->
                                list[index] = item + 1
                            }
                        }
                    }
                }
                println("charIndex: $charIndex ---- char: $char ---- list: $list")
                println("")
            }
            return list.any { it == 0 }
        }
    }
}

fun main() {
//    ValidParenthesisString.checkValidString2(")))***").println()
//    ValidParenthesisString.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())").println()
    ValidParenthesisString.checkValidString2("(((((*(((((*((**(((*)*((((**))*)*)))))))))((*(((").println()
//    ValidParenthesisString.checkValidString2("(*)").println()
//    ValidParenthesisString.checkValidString("*(").println()
//    ValidParenthesisString.checkValidString("(*))").println()
//    ValidParenthesisString.checkValidString("(").println()
//    ValidParenthesisString.checkValidString(")").println()
//    ValidParenthesisString.checkValidString("*(").println()
//    ValidParenthesisString.checkValidString(")*").println()
//    ValidParenthesisString.checkValidString("(*").println()
//    ValidParenthesisString.checkValidString("*)").println()
//  ValidParenthesisString.checkValidString("()").println()
//  ValidParenthesisString.checkValidString("(*)").println()
//  ValidParenthesisString.checkValidString("(*))()").println()
//  ValidParenthesisString.checkValidString("())").println()
//    ValidParenthesisString.checkValidString2("(****)))").println()
//    ValidParenthesisString.checkValidString2("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()").println()
//    ValidParenthesisString.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())").println()
}