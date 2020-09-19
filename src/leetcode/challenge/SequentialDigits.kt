package leetcode.challenge

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3465/
// https://leetcode.com/submissions/detail/397767936/?from=/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3465/
class SequentialDigits {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        var lowDigits = low.toString().length
        val highDigits = high.toString().length
        val outputList = ArrayList<Int>()
        while (lowDigits <= highDigits) {
            if (lowDigits > 9) {
                break
            }
            val array = IntArray(lowDigits)
            var flag = true
            while (flag) {
                if (array[0] == 0) {
                    for (index in 0..array.lastIndex) {
                        array[index] = index + 1
                    }
                } else {
                    for (index in 0..array.lastIndex) {
                        array[index]++
                    }
                }
                if (array.last() == 9) flag = false
                val generatedNumber = array.joinToString(separator = "").toInt()
                if (generatedNumber in low..high) {
                    outputList.add(generatedNumber)
                }
            }
            lowDigits++
        }
        return outputList
    }
}

fun main() {
    SequentialDigits().sequentialDigits(10, 1000000000)
}