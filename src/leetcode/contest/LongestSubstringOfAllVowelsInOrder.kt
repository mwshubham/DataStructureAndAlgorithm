package leetcode.contest

import kotlin1.println

/**
 * 5740. Longest Substring Of All Vowels in Order
 * https://leetcode.com/contest/weekly-contest-238/problems/longest-substring-of-all-vowels-in-order/
 * https://leetcode.com/submissions/detail/484860053/
 */
//"aeiaaioaaaaeiiiiouuuooaauuaeiu"
//"aeeeiiiioooauuuaeiou"
//"a"
//"aeiou"
//"u"
class LongestSubstringOfAllVowelsInOrder {
    companion object {
        fun longestBeautifulSubstring(word: String): Int {
            val vowels = arrayOf('a', 'e', 'i', 'o', 'u')
            var vowelRear = vowels.lastIndex

            var output = 0
            var outputRear = -1
            for (i in word.lastIndex downTo 0) {
                val char = word[i]
                if (char == vowels[vowelRear]) {
                    if (outputRear == -1) {
                        if (char == 'u') {
                            outputRear = i
                        }
                    }
                    if (outputRear != -1){
                        if (char == 'a') {
                            output = maxOf(output, outputRear - i + 1)
                        }
                    }
                } else if (vowelRear != 0 && char == vowels[vowelRear - 1]) {
                    if (char == 'a') {
                        output = maxOf(output, outputRear - i + 1)
                    }
                    // updating vowel read to new one
                    vowelRear--
                } else {
                    // reset vowel rear
                    vowelRear = vowels.lastIndex
                    outputRear = if (char == 'u') {
                        i
                    } else {
                        -1
                    }
                }
            }
            return output
        }
    }
}

fun main() {
    LongestSubstringOfAllVowelsInOrder.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu").println()
    LongestSubstringOfAllVowelsInOrder.longestBeautifulSubstring("aeeeiiiioooauuuaeiou").println()
    LongestSubstringOfAllVowelsInOrder.longestBeautifulSubstring("aeiou").println()
    LongestSubstringOfAllVowelsInOrder.longestBeautifulSubstring("u").println()
    LongestSubstringOfAllVowelsInOrder.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu").println()
}