package leetcode.problems.category.array.medium

import kotlin1.println

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/778/
 * https://leetcode.com/submissions/detail/597218195/?from=explore&item_id=778
 */
class GroupAnagrams {

    companion object {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val out = ArrayList<ArrayList<String>>()
            if (strs.isEmpty()) return out

            val map = HashMap<String, ArrayList<String>>()
            strs.forEach { str ->
                val charArray = CharArray(26)
                str.forEach { ch ->
                    charArray[ch - 'a'] = charArray[ch - 'a'] + 1
                }
                val key = String(charArray)
                if (!map.contains(key)) {
                    map[key] = ArrayList()
                }
                map[key]!!.add(str)
            }
            map.forEach {
                out.add(it.value)
            }

            return out
        }
    }
}

fun main() {
    GroupAnagrams.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).println()
}
