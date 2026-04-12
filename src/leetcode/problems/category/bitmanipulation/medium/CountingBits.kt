package leetcode.problems.category.bitmanipulation.medium

import kotlin.math.log
import kotlin.math.pow

/**
 * 338. Counting Bits
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/
 * https://leetcode.com/submissions/detail/346115460/?from=/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/
 */
class CountingBits {
    fun countBits0(num: Int): IntArray {
        val result = IntArray(num + 1)
        var index = 1 //p tracks the index for number x
        var pow = 1
        for (tempNum in 1..num) {
//            println("tempNum: $tempNum")
//            println("pow: $pow")
//            println("index: $index")
//            println()
//            println()
            if (tempNum == pow) {
                result[tempNum] = 1
                pow = pow shl 1
                index = 1
            } else {
//                println("result[$index]: ${result[index]}")
                result[tempNum] = result[index] + 1
                index++
            }
        }
        return result
    }

    fun countBits3(n: Int): IntArray {
        val res = IntArray(n + 1)
        for (i in res.indices) {
            when (i) {
                0 -> res[i] = 0
                1 -> res[i] = 1
                else -> {
                    res[i] = res[i / 2] + (i % 2)
                }
            }
        }
        return res
    }

    fun countBits2(n: Int): IntArray {
        val res = IntArray(n + 1)
        if (n == 0) return res
        res[1] = 1
        if (n == 1) {
            return res
        }
        res[2] = 1
        if (n == 2) {
            return res
        }
        res[3] = 2
        if (n == 3) {
            return res
        }

        var repeat = 2
        var current = 2 * repeat
        while (current <= n) {
            var tempRepeat = repeat
            repeat(repeat) {
                if (current > n) return res
                res[current] = res[tempRepeat++]
                current++
            }
            tempRepeat = repeat
            repeat(repeat) {
                if (current > n) return res
                res[current] = res[tempRepeat++] + 1
                current++
            }
            repeat = current
        }
        return res
    }

    fun countBits(n: Int): IntArray {
        val res = IntArray(n + 1)
        for (i in 0..n) {
            var num = i
            var count = 0
            var pow = log(num.toDouble(), 2.0).toInt()

            while (num > 0) {
                println("pow: $pow")
                println("num: $num")

                val reduceBy = 2.0.pow(pow--).toInt()
                println("reduceBy: $reduceBy")

                if (num >= reduceBy) {
                    num -= reduceBy
                    println("new num: $num")
                    count++
                    println("count: $count")
                }

            }
            res[i] = count
            println()
            println()
        }
        return res
    }
}

fun main() {
    val instance = CountingBits()
    println(instance.countBits(3).asList())
}