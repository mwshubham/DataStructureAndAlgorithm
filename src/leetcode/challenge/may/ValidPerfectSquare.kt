package leetcode.challenge.may

import kotlin.math.abs

// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/
// https://leetcode.com/submissions/detail/336761602/?from=/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/
class ValidPerfectSquare {

    private val validModArr = intArrayOf(0, 1, 4, 5, 6, 9)
    private val validPerfectSquareBelowTen = intArrayOf(0, 1, 2, 4, 9)
    fun isPerfectSquare(n: Int): Boolean {
        val num = abs(n)
        val mod = num % 10
        println()
        println()
        println("num: $num")
//        println("mod: $mod")
        if (mod !in validModArr) {
            return false
        }
        if (num in validPerfectSquareBelowTen) {
            return true
        }
        if (mod == 0) {
            var tempNum = num
            var countNoOfTrailingZeroes = 0
            while (tempNum % 10 == 0) {
                tempNum /= 10
                countNoOfTrailingZeroes++
            }
            println("countNoOfTrailingZeroes : $countNoOfTrailingZeroes")
            if (countNoOfTrailingZeroes % 2 == 0) {
                return isPerfectSquare(tempNum)
            }
        }
        when (mod) {
            1 -> {
                // check divisibility by no ending with 1 or 11 or 9
                return check(num, 1) or check(num, 9)
            }
            4 -> {
                // check divisibility by no ending with 2 or 8
                return check(num, 2) || check(num, 8)
            }
            5 -> {
                // check divisibility by no ending with 5
                return check(num, 5)
            }
            6 -> {
                // check divisibility by no ending with 4 or 6
                return check(num, 4) || check(num, 6)
            }
            9 -> {
                // check divisibility by no ending with 3 or 7
                return check(num, 3) || check(num, 7)
            }
        }
        return false
    }

    fun check(num: Int, endingNum: Int): Boolean {
        // check divisibility by no ending with 5
        var startNumber = endingNum
        var endNumber = normalizeToUpcomingOrSame(num / 2, endingNum)
        var lastEndNumber = num

        while (true) {
            println("startNumber: $startNumber")
            println("endNumber: $endNumber")
            println("lastEndNumber: $lastEndNumber")
            val start2 = startNumber * startNumber.toLong()
            val end2 = endNumber * endNumber.toLong()
            if (lastEndNumber == endNumber || startNumber == endNumber) {
                return false
            } else if (start2 == num.toLong()) {
                return true
            } else if (end2 == num.toLong()) {
                return true
            } else if (end2 - num.toLong() >= num.toLong() - start2) {
                val normalizedNumber = normalizeToUpcomingOrSame((startNumber + endNumber) / 2, endingNum)
                val normalizedNumber2 = normalizedNumber * normalizedNumber.toLong()
                if (normalizedNumber2 == num.toLong()) {
                    return true
                } else if (normalizedNumber2 < num) {
                    startNumber = normalizedNumber
                } else {
                    lastEndNumber = endNumber
                    endNumber = normalizeToUpcomingOrSame((startNumber + endNumber) / 2, endingNum)
                }
            } else {
                startNumber = normalizeToUpcomingOrSame((startNumber + endNumber) / 2, endingNum)
            }
        }
    }

    fun normalizeToUpcomingOrSame(num: Int, endingNum: Int): Int {
        val mod = num % 10
        if (mod == endingNum) {
            return num
        } else if (mod < endingNum) {
            return num + endingNum - mod
        } else {
            return num + 10 + endingNum - mod
        }
    }


}

// sample 100 ms submission
//class Solution {
//    fun isPerfectSquare(num: Int): Boolean {
//        var res = num.toLong()
//        while(res*res>num){
//            res = (res + num/res)/2
//        }
//
//        return res*res==num.toLong()
//    }
//}

fun main() {
    val instance = ValidPerfectSquare()
//    println(instance.isPerfectSquare(0))
//    println(instance.isPerfectSquare(1))
//    println(instance.isPerfectSquare(7))
//    println(instance.isPerfectSquare(9))
//    println(instance.isPerfectSquare(10))
//    println(instance.isPerfectSquare(11))
//    println(instance.isPerfectSquare(13))
//    println(instance.isPerfectSquare(16))
//    println(instance.isPerfectSquare(17))
//    println(instance.isPerfectSquare(100))
//    println(instance.isPerfectSquare(101))
//    println(instance.isPerfectSquare(2500))
//    println(instance.isPerfectSquare(2501))
    println(instance.isPerfectSquare(808201))
//    println(instance.isPerfectSquare(30858025))
//    println(instance.isPerfectSquare(30858035))
}
