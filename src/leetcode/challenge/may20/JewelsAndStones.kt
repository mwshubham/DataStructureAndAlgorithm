package leetcode.challenge.may20

class JewelsAndStones {
    companion object {
        fun numJewelsInStones(J: String, S: String): Int {
            var result = 0
            val sortedCharArrayJ = CharArray(52)
            val sortedIntArrayS = IntArray(52)
            J.toCharArray().forEach {
                var asciiValue = it.toByte().toInt()
//                println("$it: $asciiValue")
                asciiValue -= if (asciiValue in 65..90) {
                    65
                } else {
                    97 - 26
                }
                sortedCharArrayJ[asciiValue] = it
            }
//            println("sortedCharArrayJ: ${sortedCharArrayJ.joinToString()}")
            S.toCharArray().forEach {
                var asciiValue = it.toByte().toInt()
                asciiValue -= if (asciiValue in 65..90) {
                    65
                } else {
                    97 - 26
                }
                sortedIntArrayS[asciiValue] += 1
            }
//            println("sortedIntArrayS: ${sortedIntArrayS.joinToString()}")
            sortedCharArrayJ.forEachIndexed { index, char ->
                if (char != '\u0000') {
                    result += sortedIntArrayS[index]
                }
            }
            return result
        }
    }
// sample 128 ms submission
//    fun numJewelsInStones(J: String, S: String): Int {
//        var m = hashMapOf<Char, Int>()
//        S.forEach { m[it] = m[it]?.plus(1) ?: 1 }
//        var c = 0
//        J.forEach { c += m[it] ?: 0 }
//        return c
//    }
}

fun main() {
    println(JewelsAndStones.numJewelsInStones("aA", "aAAbbbb"))
}