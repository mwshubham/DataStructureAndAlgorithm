package leetcode.problems.difficulty.medium

/**
 * 43. Multiply Strings
 * https://leetcode.com/problems/multiply-strings/description/
 */
class MultiplyStrings {

    companion object {
        fun multiply(num1: String, num2: String): String {
            if (num1 == "0" || num2 == "0") return "0"
            var num2Index = num2.lastIndex
            val result = Array(num1.length + num2.length) { 0 }
            while (num2Index >= 0) {
                var num1Index = num1.lastIndex
                var carry = 0
                val num2Digit = num2[num2Index] - '0'
                while (num1Index >= 0) {
                    val num1Digit = num1[num1Index] - '0'
                    val multiplyResOfTwoDigits = carry + num2Digit * num1Digit
                    val resultIndex = result.lastIndex - (num2.lastIndex - num2Index + num1.lastIndex - num1Index)
                    println("""
                        num1Index: $num1Index
                        num2Index: $num2Index
                        resultIndex: $resultIndex
                        multiplyResOfTwoDigits + carry: ($num1Digit x $num2Digit + $carry) = $multiplyResOfTwoDigits
                    """.trimIndent())
                    result[resultIndex] += multiplyResOfTwoDigits
                    carry = result[resultIndex] / 10
                    result[resultIndex] = result[resultIndex] % 10
                    println("""
                        carry: $carry
                    """.trimIndent())
                    if (num1Index == 0) {
                        while (carry != 0) {
                            result[resultIndex - 1] += carry
                            carry = 0
                            if (result[resultIndex - 1] > 9) {
                                carry = result[resultIndex - 1] / 10
                                result[resultIndex - 1] = result[resultIndex - 1] % 10
                            }
                        }
                    }
                    println("""
                        result: ${result.toList()}
                    """.trimIndent())
                    num1Index--
                }
                num2Index--
            }
            val sb = StringBuilder()
            var takeZeros = false
            for (i in result) {
                if (i == 0 && !takeZeros) {
                   continue
                }
                sb.append(i)
                takeZeros = true
            }
            return sb.toString()
        }
    }
}

fun main() {
    MultiplyStrings.multiply("123", "456").apply {
        println("${this == "56088"}, got: $this, expected: 56088")
    }
    MultiplyStrings.multiply("123456789", "987654321").apply {
        println("${this == "121932631112635269"}, got: $this, expected: 121932631112635269")
    }
}