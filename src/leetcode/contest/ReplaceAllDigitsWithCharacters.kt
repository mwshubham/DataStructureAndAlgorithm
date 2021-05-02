package leetcode.contest

import kotlin1.println
import java.lang.StringBuilder

/**
 * 1844. Replace All Digits with Characters
 * https://leetcode.com/problems/replace-all-digits-with-characters/
 */
class ReplaceAllDigitsWithCharacters {
    companion object {
        /**
         * Runtime: 152 ms, faster than 100.00% of Kotlin online submissions for Replace All Digits with Characters.
         * Memory Usage: 33.8 MB, less than 100.00% of Kotlin online submissions for Replace All Digits with Characters.
         */
        fun replaceDigits(s: String): String {
            val sb = StringBuilder()
            s.forEachIndexed { index, c ->
                if (index % 2 == 0) {
                    sb.append(c)
                } else {
                    sb.append(s[index - 1] + c.toInt() - '0'.toInt())
                }
            }
            return sb.toString()
        }
    }
}

fun main() {
    ReplaceAllDigitsWithCharacters.replaceDigits("a1c1e1").println()
    ReplaceAllDigitsWithCharacters.replaceDigits("a1b2c3d4e").println()
}