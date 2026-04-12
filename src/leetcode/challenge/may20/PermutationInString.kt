package leetcode.challenge.may20

/**
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
 * https://leetcode.com/submissions/detail/341547644/?from=/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
 */
class PermutationInString {

    fun checkInclusion(s1: String, s2: String): Boolean {

        if (s1.isEmpty() || s2.isEmpty()) return false

        val sizeS1 = s1.length
        val sizeS2 = s2.length
        val arrayS1 = IntArray(26)
        s1.toCharArray().forEach {
            arrayS1[it - 'a'] += 1
        }
        val arrayS1Copy = IntArray(26)

        s2.toCharArray().let { arrayS2 ->
            arrayS2.forEachIndexed { index, char ->
                if (index <= sizeS2 - sizeS1)
                    if (arrayS1[char - 'a'] > 0) {
                        // println("char: $char")
                        arrayS1.copyInto(arrayS1Copy)
                        var found = true
                        for (range in index until index + sizeS1) {
                            // println("range: $range")
                            // println("count before: ${arrayS1Copy[arrayS2[range] - 'a']}")
                            arrayS1Copy[arrayS2[range] - 'a'] -= 1
                            // println("count after: ${arrayS1Copy[arrayS2[range] - 'a']}")
                            if (arrayS1Copy[arrayS2[range] - 'a'] < 0) {
                                found = false
                                // println("Break -- Not Found")
                                // println()
                                // println()
                                // println()
                                break
                            }
                        }
                        if (found && arrayS1Copy.all { it == 0 }) {
                            return true
                        }
                    }
            }
        }
        return false
    }

    fun checkInclusion2(s1: String, s2: String): Boolean {
        val map = HashMap<Char, Int>()
        if (s2.length < s1.length) return false
        s1.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        val prefixMap = HashMap<Char, Int>()
        for (i in 0..s1.lastIndex) {
            prefixMap[s2[i]] = (prefixMap[s2[i]] ?: 0) + 1
        }
        if (isSame2(map, prefixMap)) return true
        for (i in s1.length..s2.lastIndex) {
            val indexRemoved = i - s1.length
            if (s2[i] == s2[indexRemoved]) continue
            prefixMap[s2[i]] = (prefixMap[s2[i]] ?: 0) + 1
            if (prefixMap[s2[indexRemoved]] == 1) prefixMap.remove(s2[indexRemoved])
            else prefixMap[s2[indexRemoved]] = (prefixMap[s2[indexRemoved]] ?: 0) - 1

            if (isSame2(map, prefixMap)) return true
        }
        return false
    }

    fun isSame2(map1: Map<Char, Int>, map2: Map<Char, Int>): Boolean {
        if (map1.size != map2.size) return false
        map1.entries.forEach { entry ->
            if (map2[entry.key] != entry.value) return false
        }
        return true
    }

    fun checkInclusion3(s1: String, s2: String): Boolean {
        val n1 = s1.length
        val n2 = s2.length
        if (n2 < n1) return false
        val freq1 = IntArray(26)
        val freq2 = IntArray(26)
        for (i in 0 until n1) {
            freq1[s1[i] - 'a']++
            freq2[s2[i] - 'a']++
        }
        var matches = (0 until 26).count { freq1[it] == freq2[it] }
        for (i in n1 until n2) {
            if (matches == 26) return true
            val newCharIndex = s2[i] - 'a'
            val oldCharIndex = s2[i - n1] - 'a'
            if (newCharIndex == oldCharIndex) continue

            freq2[newCharIndex]++
            if (freq2[newCharIndex] - 1 == freq1[newCharIndex]) matches--
            else if (freq2[newCharIndex] == freq1[newCharIndex]) matches++

            freq2[oldCharIndex]--
            if (freq2[oldCharIndex] + 1 == freq1[oldCharIndex]) matches--
            else if (freq2[oldCharIndex] == freq1[oldCharIndex]) matches++
        }
        return matches == 26
    }
}

fun main() {
    val instance = PermutationInString()
    println(instance.checkInclusion("ab", "eidbaooo")) // true
    println(instance.checkInclusion("ab", "eidboaoo")) // false
    println(instance.checkInclusion("adc", "dcda")) // true
    println(instance.checkInclusion("hello", "ooolleoooleh")) // false
}