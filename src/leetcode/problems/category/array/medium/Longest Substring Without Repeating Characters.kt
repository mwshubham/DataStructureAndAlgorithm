package leetcode.problems.category.array.medium

import kotlin1.println
import kotlin.math.max

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/
 * https://leetcode.com/submissions/detail/597231792/?from=explore&item_id=779
 */
class `Longest Substring Without Repeating Characters` {

    companion object {
        /**
         * Runtime: 212 ms, faster than 65.84% of Kotlin online submissions for Longest Substring Without Repeating Characters.
         * Memory Usage: 38.9 MB, less than 32.04% of Kotlin online submissions for Longest Substring Without Repeating Characters.
         */
        fun lengthOfLongestSubstring(s: String): Int {
            val map = HashMap<Char, Int>()
            if (s.isEmpty()) return 0
            var res = 0
            var start = 0
            for (i in s.indices) {
                if (map.contains(s[i])) {
                    val newStart = map[s[i]]!! + 1
                    for (j in start..map[s[i]]!!) {
                        map.remove(s[j])
                    }
                    start = newStart
                } else {
                    res = max(res, i - start + 1)
                }
                map[s[i]] = i
            }
            return res
        }
    }
}

fun main() {
    `Longest Substring Without Repeating Characters`.lengthOfLongestSubstring("abcabcbb").println()
}