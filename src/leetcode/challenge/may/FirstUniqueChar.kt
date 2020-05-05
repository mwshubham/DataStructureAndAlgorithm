package leetcode.challenge.may

class FirstUniqueChar {

    companion object {
        @Suppress("SpellCheckingInspection")
        fun firstUniqChar(input: String): Int {
            val countMap = hashMapOf<Char, Int>()
            input.forEach { index -> countMap[index] = countMap[index]?.plus(1) ?: 1 }
            input.forEachIndexed { index, char ->
                if (countMap[char] == 1) {
                    return index
                }
            }
            return -1
        }


        // sample 232 ms submission
//        fun firstUniqChar(input: String): Int {
//            val map = IntArray(26)
//            input.forEach { char -> map[char - 'a']++ }
//            input.forEachIndexed { index, char -> if (map[char - 'a'] == 1) return index }
//            return -1
//        }
    }
}

fun main() {
    println(FirstUniqueChar.firstUniqChar("leetcode")) // 0
    println(FirstUniqueChar.firstUniqChar("loveleetcode")) // 2
    println(FirstUniqueChar.firstUniqChar("aadadaad")) // -1
}