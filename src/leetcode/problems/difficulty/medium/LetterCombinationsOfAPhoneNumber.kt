package leetcode.problems.difficulty.medium

import java.util.*
import kotlin.collections.ArrayList

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
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
}