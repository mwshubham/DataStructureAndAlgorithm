package leetcode.problems.category.string.easy

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 */
class ReverseInteger {
    fun reverse(x: Int): Int {
        var x = x
        var result = 0
        while (x != 0) {
            val tail = x % 10
            val newResult = result * 10 + tail
            // To check overflow
            if ((newResult - tail) / 10 != result) {
                return 0
            }
            result = newResult
            x /= 10
        }
        return result
    }
}