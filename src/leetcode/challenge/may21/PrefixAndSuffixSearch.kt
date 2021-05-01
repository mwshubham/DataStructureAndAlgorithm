package leetcode.challenge.may21

/**
 * 745. Prefix and Suffix Search
 * https://leetcode.com/problems/prefix-and-suffix-search/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3728/
 * https://leetcode.com/submissions/detail/487358312/?from=explore&item_id=3728
 *
 * For a word like "test", consider "#test", "t#test", "st#test", "est#test", "test#test".
 * Then if we have a query like prefix = "te", suffix = "t", we can find it by searching for something we've inserted starting with "t#te".
 */
class WordFilter(words: Array<String>) {
    val map = HashMap<String, Int>()

    init {
        words.forEachIndexed { index, word ->
            for (i in 0..word.length) {
                for (j in 0..word.length) {
                    // prefix#suffix
                    map["${word.substring(0, i)}#${word.substring(word.length - j)}"] = index
                }
            }
        }
    }

    fun f(prefix: String, suffix: String): Int {
        return map["$prefix#$suffix"] ?: -1
    }

}