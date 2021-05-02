package leetcode.contest

import kotlin1.println
import java.lang.StringBuilder

class ReplaceAllDigitsWithCharacters {
    companion object {
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