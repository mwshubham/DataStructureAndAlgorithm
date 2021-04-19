package leetcode.problems.category.string.easy

/**
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
class FirstUniqueChar {

    companion object {

        /**
         * Runtime: 248 ms, faster than 80.00% of Kotlin online submissions for First Unique Character in a String.
         * Memory Usage: 36.1 MB, less than 84.00% of Kotlin online submissions for First Unique Character in a String.
         */
        @Suppress("SpellCheckingInspection")
        fun firstUniqChar(input: String): Int {
            val countMap = hashMapOf<Char, Int>()
            input.forEach { index -> countMap[index] = countMap[index]?.plus(1) ?: 1 }
            input.forEachIndexed { index, char ->
                if (countMap[char] == 1) {
                    return index
                }
            }
            return -1
        }


        /**
         * Runtime: 208 ms, faster than 97.14% of Kotlin online submissions for First Unique Character in a String.
         * Memory Usage: 36.2 MB, less than 50.86% of Kotlin online submissions for First Unique Character in a String.
         */
        fun firstUniqCharUsingArray(input: String): Int {
            val map = IntArray(26)
            input.forEach { char -> map[char - 'a']++ }
            input.forEachIndexed { index, char -> if (map[char - 'a'] == 1) return index }
            return -1
        }
    }
}

fun main() {
    println(FirstUniqueChar.firstUniqChar("leetcode")) // 0
    println(FirstUniqueChar.firstUniqChar("loveleetcode")) // 2
    println(FirstUniqueChar.firstUniqChar("aadadaad")) // -1
}