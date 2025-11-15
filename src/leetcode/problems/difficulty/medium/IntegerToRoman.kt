package leetcode.problems.difficulty.medium

import java.util.Stack

/**
 * 12. Integer to Roman
 *
 * https://leetcode.com/problems/integer-to-roman/description
 */
class IntegerToRoman {

    companion object {
        // 1, 10, 100, 1000
        private val tenMap = arrayOf('I', 'X', 'C', 'M')

        // 5, 50, 500
        private val fiveMap = arrayOf('V', 'L', 'D')

        fun intToRoman(num: Int): String {
            val stack = Stack<Char>()
            var updatedNum = num
            var index = 0
            while (updatedNum > 0) {
                val remainder = updatedNum % 10
                updatedNum /= 10
                when (remainder) {
                    in 1..3 -> {
                        repeat(remainder) {
                            stack.push(tenMap[index])
                        }
                    }

                    4 -> {
                        stack.push(fiveMap[index])
                        stack.push(tenMap[index])
                    }

                    5 -> {
                        stack.push(fiveMap[index])
                    }

                    in 6..8 -> {
                        repeat(remainder - 5) {
                            stack.push(tenMap[index])
                        }
                        stack.push(fiveMap[index])
                    }

                    9 -> {
                        stack.push(tenMap[index + 1])
                        stack.push(tenMap[index])
                    }
                }
                index++
            }
            val result = StringBuilder()
            while (stack.isNotEmpty()) {
                result.append(stack.pop())
            }
            return result.toString()
        }

        private val values = arrayOf(
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4,
            1
        )

        private val symbols = arrayOf(
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV",
            "I"
        )

        fun intToRoman2(num: Int): String {
            val result = StringBuilder()
            var number = num
            var index = 0
            while (number > 0) {
                if (number >= values[index]) {
                    number -= values[index]
                    result.append(symbols[index])
                } else {
                    index++
                }
            }
            return result.toString()
        }
    }
}

fun main() {
    IntegerToRoman.intToRoman2(3749).apply {
        println("num: 3749, roman: $this")
        println(this == "MMMDCCXLIX")
    }
    IntegerToRoman.intToRoman2(3210).apply {
        println("num: 3210, roman: $this")
        println(this == "MMMCCX")
    }
    IntegerToRoman.intToRoman2(58).apply {
        println("num: 58, roman: $this")
        println(this == "LVIII")
    }
    IntegerToRoman.intToRoman2(400).apply {
        println("num: 400, roman: $this")
        println(this == "CD")
    }
    IntegerToRoman.intToRoman2(490).apply {
        println("num: 490, roman: $this")
        println(this == "CDXC")
    }
    IntegerToRoman.intToRoman2(409).apply {
        println("num: 409, roman: $this")
        println(this == "CDIX")
    }
    println("----")
    println("----")
    println("----")
    IntegerToRoman.intToRoman(3749).apply {
        println("num: 3749, roman: $this")
        println(this == "MMMDCCXLIX")
    }
    IntegerToRoman.intToRoman(3210).apply {
        println("num: 3210, roman: $this")
        println(this == "MMMCCX")
    }
    IntegerToRoman.intToRoman(58).apply {
        println("num: 58, roman: $this")
        println(this == "LVIII")
    }
    IntegerToRoman.intToRoman(400).apply {
        println("num: 400, roman: $this")
        println(this == "CD")
    }
    IntegerToRoman.intToRoman(490).apply {
        println("num: 490, roman: $this")
        println(this == "CDXC")
    }
    IntegerToRoman.intToRoman(409).apply {
        println("num: 409, roman: $this")
        println(this == "CDIX")
    }
}