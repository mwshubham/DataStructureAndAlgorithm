package leetcode.challenge.april


/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3699/
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 */
class DetermineIfStringHalvesAreAlike {
    /**
     * https://leetcode.com/submissions/detail/477584841/?from=explore&item_id=3699
     *
     * Runtime: 168 ms, faster than 82.35% of Kotlin online submissions for Determine if String Halves Are Alike.
     * Memory Usage: 36.5 MB, less than 17.65% of Kotlin online submissions for Determine if String Halves Are Alike.
     */
    companion object {
        fun halvesAreAlike(s: String): Boolean {
            val vowels = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
            var count = 0
            for (i in 0 until s.length / 2) {
                if (vowels.contains(s[i])) count++
            }
            for (i in s.length / 2 until s.length) {
                if (vowels.contains(s[i])) count--
            }
            return count == 0
        }
    }
}