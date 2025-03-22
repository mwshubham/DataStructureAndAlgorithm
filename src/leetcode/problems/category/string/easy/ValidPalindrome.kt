package leetcode.problems.category.string.easy

import kotlin1.println

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 */
class ValidPalindrome {

    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        var head = 0
        var tail: Int = s.length - 1
        var cHead: Char
        var cTail: Char
        while (head <= tail) {
            cHead = s[head]
            cTail = s[tail]
            if (!Character.isLetterOrDigit(cHead)) {
                head++
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false
                }
                head++
                tail--
            }
        }
        return true
    }

    fun isPalindrome2(s: String): Boolean {
        var start = 0
        var end = s.lastIndex

        val cA = 'A'
        val cZ = 'Z'
        val ca = 'a'
        val cz = 'z'
        val c0 = '0'
        val c9 = '9'

        var chStart: Char?
        var chEnd: Char?

        while (start < end) {
            chStart = s[start]
            chEnd = s[end]

            if (chStart in cA..cZ) {
                chStart = ((chStart - 'A') + 'a'.code).toChar()
            } else if (
                chStart !in ca..cz
                && chStart !in c0..c9
            ) {
                start++
                continue
            }

            if (chEnd in cA..cZ) {
                chEnd = ((chEnd - 'A') + 'a'.code).toChar()
            } else if (
                chEnd !in ca..cz
                && chEnd !in c0..c9
            ) {
                end--
                continue
            }

            if (chStart != chEnd) {
                return false
            }

            start++
            end--
        }

        return true
    }
}

fun main() {
    ValidPalindrome().apply {
        isPalindrome2("A man, a plan, a canal: Panama").println()
        isPalindrome2("race a car").println()
        isPalindrome2(" ").println()
        isPalindrome2("aa").println()
        isPalindrome2("0P").println()
    }
}