package leetcode.problems.difficulty

// https://leetcode.com/problems/add-binary/
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3395/
// https://leetcode.com/submissions/detail/369023666/?from=/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3395/
class AddBinary {

    fun addBinary(a: String?, b: String?): String? {
        if (a == null || a.isEmpty()) return b
        if (b == null || b.isEmpty()) return a
        val stb = StringBuilder()
        var i = a.length - 1
        var j = b.length - 1
        var aBit: Int
        var bBit: Int
        var carry = 0
        var result: Int
        while (i >= 0 || j >= 0 || carry == 1) {
            aBit = if (i >= 0) Character.getNumericValue(a[i--]) else 0
            bBit = if (j >= 0) Character.getNumericValue(b[j--]) else 0
            result = aBit xor bBit xor carry
            carry = if (aBit + bBit + carry >= 2) 1 else 0
            stb.append(result)
        }
        return stb.reverse().toString()
    }
}