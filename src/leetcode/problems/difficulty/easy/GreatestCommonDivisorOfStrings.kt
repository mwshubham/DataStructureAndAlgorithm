package leetcode.problems.difficulty.easy

import kotlin1.println

/**
 * 1071. Greatest Common Divisor of Strings.
 * https://leetcode.com/problems/greatest-common-divisor-of-strings
 */
class GreatestCommonDivisorOfStrings {
    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1.isEmpty() && str1.isEmpty()) return ""
        val sLen: Int
        val tLen: Int
        if (str1.length >= str2.length) {
            sLen = str1.length
            tLen = str2.length
        } else {
            sLen = str2.length
            tLen = str1.length
        }
        if (sLen != 0 && tLen == 0) return ""
        if ((str1 + str2) != str2 + str1)
            return ""
        var gcdLen = tLen
        while (gcdLen > 0) {
            if (sLen % gcdLen == 0 && tLen % gcdLen == 0) {
                val gcdStr = str2.substring(0, gcdLen)
                if (gcd(str1, gcdStr) && gcd(str2, gcdStr)) {
                    return gcdStr
                } else {
                    gcdLen--
                }
            } else {
                gcdLen--
            }
        }
        return ""
    }

    fun gcd(str1: String, str2: String): Boolean {
        if (str1.length % str2.length != 0) return false
        str1.forEachIndexed { index, ch ->
            if (ch != str2[index % str2.length]) return false
        }
        return true
    }


    fun gcdOfStrings2(str1: String, str2: String): String {
        if((str1+str2) != str2+str1)
            return ""

        return str1.substring(0,gcd2(str1.length,str2.length))
    }

    private fun gcd2(length1:Int,length2:Int):Int{
        var len1 = length1
        var len2 = length2
        while(len2 != 0){
            val temp = len1 % len2
            len1 = len2
            len2 = temp
        }
        return len1
    }

}

fun main() {
    GreatestCommonDivisorOfStrings().apply {
//        gcdOfStrings(
//            "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX",
//            "TAUXXTAUXXTAUXXTAUXXTAUXX"
//        ).println()

        gcdOfStrings(
            "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZQJXZKMPVYWTBAOHNRLIEGDSCUFABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZZYXWVUTSRQPONMLKJIHGFEDCBAABCDEFGHIJKLMNOPQRSTUVWXYZ"
        ).println()
    }
}