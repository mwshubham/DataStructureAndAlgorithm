package leetcode.problems.difficulty

/**
 * https://leetcode.com/problems/shuffle-string/
 */
class ShuffleString {
    fun restoreString(s: String, indices: IntArray): String {
        val array = s.toCharArray()
        val result = CharArray(array.size)
        for (i in array.indices) {
            result[indices[i]] = array[i]
        }
        return String(result)
    }
}