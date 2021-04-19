package leetcode.problems.difficulty

import java.util.*
import kotlin.collections.ArrayList

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
class LetterCombinationsOfAPhoneNumber {
    /**
     * Runtime: 160 ms, faster than 84.16% of Kotlin online submissions for Letter Combinations of a Phone Number.
     * Memory Usage: 35.2 MB, less than 96.53% of Kotlin online submissions for Letter Combinations of a Phone Number.
     */
    fun letterCombinations(digits: String): List<String> {
        val ans = LinkedList<String>()
        if (digits.isEmpty()) return ans
        val mapping = arrayOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        ans.add("") // adding empty for our use-case
        while (ans.peek().length != digits.length) {
            val first = ans.removeFirst()
            val map = mapping[digits[first.length] - '0']
            map.forEach {
                ans.addLast(first + it)
            }
        }
        return ans
    }

    companion object {
        val digitCharMap = Array<List<Char>>(9) { ArrayList(0) }
            .apply {
                set(2, listOf('a', 'b', 'c'))
                set(3, listOf('d', 'e', 'f'))
                set(4, listOf('g', 'h', 'i'))
                set(5, listOf('j', 'k', 'l'))
                set(6, listOf('m', 'n', 'o'))
                set(7, listOf('p', 'q', 'r', 's'))
                set(8, listOf('t', 'u', 'v'))
                set(9, listOf('w', 'x', 'y', 'z'))
            }
    }
}