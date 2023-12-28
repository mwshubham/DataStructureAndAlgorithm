package leetcode.problems.difficulty.medium

import kotlin1.println
import java.lang.StringBuilder
import kotlin.math.absoluteValue

/**
 * 166. Fraction to Recurring Decimal
 * https://leetcode.com/submissions/detail/1130417338/?from=explore&item_id=821
 */
class FractionToRecurringDecimal {

    companion object {
        fun fractionToDecimal(numerator: Int, denominator: Int): String {
            if (numerator == 0) return "0"
            val res = StringBuilder()
            if ((numerator > 0) xor (denominator > 0)) {
                res.append("-")
            }

            var numLong = numerator.toLong().absoluteValue
            val denLong = denominator.toLong().absoluteValue

            // Integral part
            res.append(numLong / denLong)
            numLong %= denLong
            if (numLong == 0L) {
                return res.toString()
            }

            // Fractional Part
            res.append(".")
            val map = HashMap<Long, Int>()

            // Added remainder
            map[numLong] = res.length
            while (numLong != 0L) {
                numLong *= 10
                res.append(numLong / denLong)
                numLong %= denLong
                if (map.containsKey(numLong)) {
                    val index = map[numLong]!!
                    res.insert(index, "(")
                    res.append(")")
                    break
                } else {
                    map[numLong] = res.length
                }
            }
            return res.toString()
        }
    }
}

fun main() {
    FractionToRecurringDecimal.fractionToDecimal(1, 2).println()
    FractionToRecurringDecimal.fractionToDecimal(4, 333).println()
    FractionToRecurringDecimal.fractionToDecimal(-50, 8).println()
    // "0.0000000004656612873077392578125"
    FractionToRecurringDecimal.fractionToDecimal(-1, -2147483648).println()
}