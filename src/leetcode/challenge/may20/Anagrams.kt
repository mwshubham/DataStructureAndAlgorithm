package leetcode.challenge.may20

// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
// https://leetcode.com/submissions/detail/340686422/?from=/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
class Anagrams {

    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        if (s.isEmpty() || p.isEmpty()) return result
        val lengthS = s.length
        val lengthP = p.length

        if (lengthP > lengthS) {
            return result
        }

        val arrayP = IntArray(26)
        p.toCharArray().forEach {
            arrayP[it - 'a'] += 1
        }
        val arrayPCopy = IntArray(26)


        s.toCharArray().apply {
            var index = 0
            while (index < (lengthS - lengthP + 1)) {
//                println("index: $index")

                if (arrayP[get(index) - 'a'] > 0) {
                    arrayP.copyInto(arrayPCopy)
                    var found = true
                    for (range in index until index + lengthP) {
                        arrayPCopy[get(range) - 'a'] -= 1
                        if (arrayPCopy[get(range) - 'a'] < 0) {
                            found = false
                            break
                        }
                    }
                    if (found && arrayPCopy.all { it == 0 }) {
//                        println("found: $index")
                        result.add(index)
                    }
                }
                index += 1
            }
        }
        return result
    }

    // sample 200 ms submission
//    fun findAnagrams(s: String, p: String): List<Int> {
//        val res = mutableListOf<Int>()
//        if (s.length == 0 || p.length == 0 || p.length > s.length) {
//            return res
//        }
//        val hash = IntArray(26)
//        var start = 0
//        var end = 0
//        var count = p.length
//        for (i in 0 until p.length) {
//            hash[p[i] - 'a']++
//        }
//        while (end < s.length) {
//            if (hash[s[end++] - 'a']-- >= 1) {
//                count--
//            }
//            if (count == 0) {
//                res.add(start)
//            }
//            if (end - start == p.length) {
//                if (hash[s[start++] - 'a']++ >= 0) {
//                    count++
//                }
//            }
//        }
//        return res
//    }
}

fun main() {
    val instance = Anagrams()
//    println(instance.findAnagrams("", "")) // []
//    println(instance.findAnagrams("emptystring", "")) // []
//    println(instance.findAnagrams("", "emptyp")) // []
//    println(instance.findAnagrams("short", "lengthismore")) // []

//    println(instance.findAnagrams("cbaebabacd", "abc")) // [0, 6]
//    println(instance.findAnagrams("abab", "ab")) // [0, 1, 2]
    println(instance.findAnagrams("abacbabc", "abc")) // [0, 1, 2]
}