package leetcode.problems.difficulty.easy


/**
 * 1832. Check if the Sentence Is Pangram
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */
class CheckIfTheSentenceIsPangram {
    companion object {
        /**
         * Runtime: 267 ms, faster than 66.67% of Kotlin online submissions for Check if the Sentence Is Pangram.
         * Memory Usage: 34.8 MB, less than 80.39% of Kotlin online submissions for Check if the Sentence Is Pangram.
         */
        fun checkIfPangram(sentence: String): Boolean {
            val s = HashSet<Char>()
            sentence.forEach {
                s.add(it)
            }
            return s.size == 26
        }
    }
}