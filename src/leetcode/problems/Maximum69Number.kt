package leetcode.problems

class Maximum69Number {

    /**
     * Runtime: 136 ms, faster than 83.64% of Kotlin online submissions for Maximum 69 Number.
     * Memory Usage: 33.4 MB, less than 21.82% of Kotlin online submissions for Maximum 69 Number.
     */
    fun maximum69Number(num: Int): Int {
        return num.toString().replaceFirst("6", "9").toInt()
    }

    /**
     * Runtime: 132 ms, faster than 92.73% of Kotlin online submissions for Maximum 69 Number.
     * Memory Usage: 32.3 MB, less than 50.91% of Kotlin online submissions for Maximum 69 Number.
     */
    fun maximum69Number2(num: Int): Int {
        val chars = num.toString().toCharArray()
        for (i in chars.indices) {
            if (chars[i] == '6') {
                chars[i] = '9'
                break
            }
        }
        return String(chars).toInt()
    }
}