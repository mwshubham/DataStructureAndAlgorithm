package leetcode.problems.category.bitmanipulation.medium

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/
 * https://leetcode.com/submissions/detail/346115460/?from=/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/
 */
class CountingBits {
    fun countBits(num: Int): IntArray {
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
}

fun main() {
    val instance = CountingBits()
    println(instance.countBits(3).asList())
}