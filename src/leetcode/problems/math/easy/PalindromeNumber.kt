package leetcode.problems.math.easy

// https://leetcode.com/problems/palindrome-number/
class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false
        }
        @Suppress("NAME_SHADOWING") var x = x
        var revertedNumber = 0
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10
            x /= 10
        }
        return x == revertedNumber || x == revertedNumber/10
    }
}

private fun main(){
    val instance = PalindromeNumber()
    println(instance.isPalindrome(121)) // true
    println(instance.isPalindrome(-121)) // false
    println(instance.isPalindrome(10)) // false
    println(instance.isPalindrome(1234321)) // true
    println(instance.isPalindrome(0)) // true
}