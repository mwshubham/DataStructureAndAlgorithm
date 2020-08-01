package leetcode.problems.dynamicprogramming.easy

// https://leetcode.com/problems/climbing-stairs/
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3407/
class Solution {
    fun climbStairs(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        if (n == 2) return 2
        var a = 1
        var b = 2
        var sum = 0
        (3..n).forEach {
            sum = a + b
            a = b
            b = sum
        }
        return sum
    }
}