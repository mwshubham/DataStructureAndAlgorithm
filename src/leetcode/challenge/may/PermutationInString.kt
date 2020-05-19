package leetcode.challenge.may

// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
// https://leetcode.com/submissions/detail/341547644/?from=/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
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
}

fun main() {
    val instance = PermutationInString()
    println(instance.checkInclusion("ab", "eidbaooo")) // true
    println(instance.checkInclusion("ab", "eidboaoo")) // false
    println(instance.checkInclusion("adc", "dcda")) // true
    println(instance.checkInclusion("hello", "ooolleoooleh")) // false
}