package leetcode.problems.category.string.easy

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 */
class ValidAnagram {
    /**
     * Runtime: 168 ms, faster than 96.30% of Kotlin online submissions for Valid Anagram.
     * Memory Usage: 35.8 MB, less than 84.57% of Kotlin online submissions for Valid Anagram.
     */
    fun isAnagram(s: String, t: String): Boolean {
        val alphabet = IntArray(26)
        for (i in s.indices) alphabet[s[i] - 'a']++
        for (i in t.indices) alphabet[t[i] - 'a']--
        for (i in alphabet) if (i != 0) return false
        return true
    }
}