package leetcode.challenge.may

import java.util.*

// https://gist.github.com/BiruLyu/324e8924eedb998130db3c3110e058e4
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/
class SortCharactersByFrequency {

    fun frequencySort(input: String): String {
        val map: MutableMap<Char, Int> = HashMap()
        input.toCharArray().forEach { char ->
            if (map.containsKey(char)) {
                map[char] = map[char]!! + 1
            } else {
                map[char] = 1
            }
        }

        val bucket = Array<MutableList<Char>?>(input.length + 1) { null }
        for (key in map.keys) {
            val frequency = map[key]!!
            if (bucket[frequency] == null) {
                bucket[frequency] = ArrayList()
            }
            bucket[frequency]!!.add(key)
        }
        val sb = StringBuilder()
        for (index in bucket.indices.reversed()) {
            if (bucket[index] != null) {
                for (num in bucket[index]!!) {
                    for (i in 0 until map[num]!!) {
                        sb.append(num)
                    }
                }
            }
        }
        return sb.toString()

    }
}