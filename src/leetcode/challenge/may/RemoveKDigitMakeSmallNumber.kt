package leetcode.challenge.may

// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
// https://leetcode.com/submissions/detail/339131847/?from=/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
class RemoveKDigitMakeSmallNumber {
    @Suppress("SpellCheckingInspection")
    fun removeKdigits(num: String, k: Int): String {
        if (num.length == k) return "0"
        if (k == 0) return num

        val strBuilder = StringBuilder(num)
        for (times in 0 until k) {
//            println("times: $times")
            var i = 0
            while (i < strBuilder.lastIndex && strBuilder[i] <= strBuilder[i + 1]) {
                i++
            }
            strBuilder.delete(i, i + 1)
        }
        return mapOutput(strBuilder.toString().trimStart('0'))
    }

    private fun mapOutput(input: String) = if (input.isEmpty()) "0" else input
}

fun main() {
    val instance = RemoveKDigitMakeSmallNumber()

    println(instance.removeKdigits("1432219", 3)) // 1219
    println(instance.removeKdigits("10200", 1)) // 200
    println(instance.removeKdigits("10", 2)) // 0
    println(instance.removeKdigits("10", 1)) // 0
}