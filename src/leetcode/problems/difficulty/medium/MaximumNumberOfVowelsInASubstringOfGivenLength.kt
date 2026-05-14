package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
 */
class MaximumNumberOfVowelsInASubstringOfGivenLength {
    fun maxVowels(s: String, k: Int): Int {
        if (s.length <= k) {
            return s.count {
                it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u'
            }
        } else {
            var count = 0
            for (i in 0 until k) {
                if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                    count++
                }
            }
            var maxCount = count
            if (count == k) {
                return count
            }
            for (i in k until s.length) {
                if (s[i - k] == 'a' || s[i - k] == 'e' || s[i - k] == 'i' || s[i - k] == 'o' || s[i - k] == 'u') {
                    count--
                }
                if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                    count++
                }
                if (count == k) {
                    return count
                }
                maxCount = Math.max(maxCount, count)
            }
            return maxCount
        }
    }
}

fun main() {
//    MaximumNumberOfVowelsInASubstringOfGivenLength().maxVowels("abciiidef", 3).println()
    MaximumNumberOfVowelsInASubstringOfGivenLength().maxVowels("leetcode", 3).println()
}
