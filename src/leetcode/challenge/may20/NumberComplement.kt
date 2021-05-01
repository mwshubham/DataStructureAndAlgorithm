package leetcode.challenge.may20

import kotlin.math.ln

class NumberComplement {
    companion object {
        fun findComplement(num: Int): Int {
            return (1 shl countBits(num)) - 1 xor num
        }

        private fun countBits(number: Int): Int {
            return (ln(number.toDouble()) / ln(2.0) + 1).toInt()
        }
    }

    // sample 128 ms submission
//    class Solution {
//        // 101 111 111000 000111 010
//        fun findComplement(num: Int): Int {
//            var mask = 0.inv()
//            while((num and mask) != 0) mask = mask shl 1
//            return num xor mask.inv()
//        }
//    }

    //sample 120 ms submission
//    class Solution {
//        fun findComplement(num: Int): Int {
//            val count = Integer.numberOfLeadingZeros(num)
//            return num.inv().shl(count).shr(count)
//        }
//    }
}

private fun main() {
    print(NumberComplement.findComplement(5)) // output: 2
}