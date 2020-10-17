@file:Suppress("unused")

package leetcode.challenge

import jdk.internal.org.jline.utils.Colors

/**
 * https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3498/
 * https://leetcode.com/submissions/detail/409786869/?from=/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3498/
 *
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
class RepeatedDnaSequence {
    fun findRepeatedDnaSequences2(s: String): List<String> {
        val seen = HashSet<String>()
        val repeated = HashSet<String>()
        var i = 0
        while (i + 9 < s.length) {
            val ten = s.substring(i, i + 10)
            if (!seen.add(ten)) repeated.add(ten)
            i++
        }
        return repeated.toList()
    }

    /**
     * Runtime: 232 ms, faster than 100.00% of Kotlin online submissions for Repeated DNA Sequences.
     * Memory Usage: 44.2 MB, less than 14.29% of Kotlin online submissions for Repeated DNA Sequences.
     */
    fun findRepeatedDnaSequences(s: String): List<String> {
        val seen = HashSet<String>()
        val repeated = HashSet<String>()
        var i = 0
        while (i + 9 < s.length) {
            val ten = s.substring(i, i + 10)
            if (!seen.add(ten)) repeated.add(ten)
            i++
        }
        return repeated.toList()
    }
}