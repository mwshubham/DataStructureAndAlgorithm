package leetcode.problems.difficulty.easy

/**
 * 1137. Nth Tribonacci Number
 * https://leetcode.com/problems/n-th-tribonacci-number
 */
class NthTribonacciNumber {
    fun tribonacci(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        if (n == 2) return 1
        var t0 = 0
        var t1 = 1
        var t2 = 1
        var sum: Int
        for (i in 3..n) {
            sum = t0 + t1 + t2
            t0 = t1
            t1 = t2
            t2 = sum
        }
        return t2
    }
}