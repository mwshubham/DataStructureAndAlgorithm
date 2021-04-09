package leetcode.challenge.april

import kotlin1.println


/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3702/
 * https://leetcode.com/submissions/detail/478462310/?from=explore&item_id=3702
 */
class VerifyingAnAlienDictionary {
    companion object {

        /**
         * Runtime: 176 ms, faster than 45.93% of Kotlin online submissions for Verifying an Alien Dictionary.
         * Memory Usage: 36.7 MB, less than 25.93% of Kotlin online submissions for Verifying an Alien Dictionary.
         */
        fun isAlienSorted(words: Array<String>, order: String): Boolean {
            val array = IntArray(26)
            order.forEachIndexed { index, char ->
                array[char - 'a'] = index
            }
            for (i in 0 until words.lastIndex) {
                val nextWord = words[i + 1]
//                if (nextWord.length < words[i].length) return false
                for (j in 0..words[i].lastIndex) {
                    val char = words[i][j]
                    val nextChar = nextWord.getOrNull(j) ?: return false
                    if (char != nextChar) {
                        if (array[char - 'a'] < array[nextChar - 'a']) break
                        if (array[char - 'a'] > array[nextChar - 'a']) return false
                    }
                }
            }
            return true
        }
    }
}

// words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
fun main() {
//    VerifyingAnAlienDictionary.isAlienSorted(
//        arrayOf("hello", "leetcode"), "hlabcdefgijkmnopqrstuvwxyz"
//    ).println()


    VerifyingAnAlienDictionary.isAlienSorted(
        arrayOf("word", "world", "row"), "worldabcefghijkmnpqstuvxyz"
    ).println()

//    VerifyingAnAlienDictionary.isAlienSorted(
//        arrayOf("kuvp", "q"), "ngxlkthsjuoqcpavbfdermiywz"
//    ).println()
}
