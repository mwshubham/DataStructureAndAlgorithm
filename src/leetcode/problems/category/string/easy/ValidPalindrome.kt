package leetcode.problems.category.string.easy

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
}