package leetcode.problems.bitmanipulation.easy

// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3388/
// https://leetcode.com/problems/reverse-bits/
// https://leetcode.com/submissions/detail/365541595/?from=/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3388/
class ReverseBits {
    fun reverseBits(n: Int): Int {
        @Suppress("NAME_SHADOWING")
        var n = n
        if (n == 0) return 0
        var result = 0
        for (i in 0..31) {
            result = result shl 1
            if (n and 1 == 1) result++
            n = n shr 1
        }
        return result
    }
}