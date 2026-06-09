package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 3325. Count Substrings With K-Frequency Characters I
 * https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i/
 */
class CountSubstringsWithKFrequencyCharactersI {

    // abacb
    // size = 5, lastIndex = 4, k = 2

    fun numberOfSubstrings(s: String, k: Int): Int {
        val length = s.length
        if (k == 1) {
            return (length * (length + 1)) / 2
        }
        var count = 0
        val frequencyMap = HashMap<Char, Int>()
        for (i in 0..(s.lastIndex - k + 1)) {
            frequencyMap.clear()
            for (j in (i)..s.lastIndex) {
                if (frequencyMap.getOrDefault(s[j], 0) >= k - 1) {
                    count += s.lastIndex - j + 1
                    println("Count: ${s.lastIndex - j + 1}")
                    println("Total Count: $count")
                    println()
                    break
                } else {
                    frequencyMap[s[j]] = (frequencyMap[s[j]] ?: 0) + 1
                }
            }
        }
        return count
    }

    fun numberOfSubstrings2(s: String, k: Int): Int {
        val length = s.length
        if (k == 1) {
            return (length * (length + 1)) / 2
        }
        var left = 0
        var count = 0
        var charsWithKFreq = 0

        val freq = IntArray(26)
        for (right in s.indices) {
            val r = s[right] - 'a'
            freq[r]++
            if (freq[r] == k) {
                charsWithKFreq++
            }
            while (charsWithKFreq > 0) {
                count += length - right
                val l = s[left] - 'a'

                if (freq[l] == k) {
                    charsWithKFreq--
                }
                freq[l]--
                left++
            }
        }
        return count
    }
}

fun main() {
    CountSubstringsWithKFrequencyCharactersI().apply {
//        numberOfSubstrings("abacb", 2).println()
//        numberOfSubstrings("abcde", 1).println()
        numberOfSubstrings("qpbhhdrrhr", 3).println()
    }
}
