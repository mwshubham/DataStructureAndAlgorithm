package leetcode.problems.string.easy

class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
//        return magazine.contains(ransomNote, true)
        if (ransomNote.isEmpty()) return true
        if (magazine.isEmpty()) return false

        val ransomNoteMap = hashMapOf<Char, Int>()
        val magazineMap = hashMapOf<Char, Int>()
        ransomNote.forEach { index -> ransomNoteMap[index] = ransomNoteMap[index]?.plus(1) ?: 1 }
        magazine.forEach { index -> magazineMap[index] = magazineMap[index]?.plus(1) ?: 1 }

        ransomNoteMap.entries.forEach { it ->
            val key = it.key
            val count = magazineMap[key]
            if (count == null || count < it.value) {
                return false
            }
        }
        return true
    }

//    sample 172 ms submission
//    fun canConstruct(ransomNote: String, magazine: String): Boolean {
//        var chars = IntArray(26) { 0 }
//        for (i in magazine.indices) {
//            chars[magazine[i] - 'a']++
//        }
//        for (i in ransomNote.indices) {
//            if (--chars[ransomNote[i] - 'a'] < 0) {
//                return false
//            }
//        }
//        return true
//    }
}

fun main() {
    println(RansomNote().canConstruct("a", "b")) // false
    println(RansomNote().canConstruct("aa", "ab")) // false
    println(RansomNote().canConstruct("aa", "aab")) // true
    println(RansomNote().canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh")) // true
}