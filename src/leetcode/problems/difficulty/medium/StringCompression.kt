package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 443. String Compression
 * https://leetcode.com/problems/string-compression/
 */
class StringCompression {

    // abbb -> ab3
    fun compress(chars: CharArray): Int {
        var index = 0
        var start = 0
        var lastChar: Char? = null
        chars.forEachIndexed { i, c ->
            if (c != lastChar) {
                if (lastChar != null) {
                    val count = (i - start)
                    chars[index++] = lastChar
                    if (count > 1) {
                        val countStr = count.toString()
                        countStr.forEach {
                            chars[index++] = it
                        }
                    }
                }
                start = i
                lastChar = c
            }
        }
        val count = (chars.size - start)
        chars[index++] = lastChar!!
        if (count > 1) {
            val countStr = count.toString()
            countStr.forEach {
                chars[index++] = it
            }
        }
        return index
    }
}

fun main() {
    StringCompression().compress(charArrayOf('a','a','b','b','c','c','c')).println()
}