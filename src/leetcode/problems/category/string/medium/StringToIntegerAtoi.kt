package leetcode.problems.category.string.medium

/**
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
class StringToIntegerAtoi {

    fun myAtoi(s: String): Int {
        var index = 0
        var total = 0
        var sign = 1

        // Check if empty string
        if (s.isEmpty()) return 0

        // remove white spaces from the string
        while (index < s.length && s[index] == ' ') index++

        if (index == s.length) return 0

        // get the sign
        if (s[index] == '+' || s[index] == '-') {
            sign = if (s[index] == '+') 1 else -1
            index++
        }

        // convert to the actual number and make sure it's not overflow

        // convert to the actual number and make sure it's not overflow
        while (index < s.length) {
            val digit: Int = s[index] - '0'
            if (digit < 0 || digit > 9) break

            // check for overflow
            if (Int.MAX_VALUE / 10 < total || Int.MAX_VALUE / 10 == total && Int.MAX_VALUE % 10 < digit) return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
            total = total * 10 + digit
            index++ // don't forget to increment the counter
        }
        return total * sign
    }
}