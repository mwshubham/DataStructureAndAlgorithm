package leetcode.problems.category.array.easy

/**
 * https://leetcode.com/problems/xor-operation-in-an-array/submissions/
 *
 * Runtime: 128 ms, faster than 60.98% of Kotlin online submissions for XOR Operation in an Array.
 * Memory Usage: 32.8 MB, less than 29.27% of Kotlin online submissions for XOR Operation in an Array.
 */
class XorOperation {

    fun xorOperation(n: Int, start: Int): Int {
        var res = start
        for (i in 1 until n) {
            res = res xor start + 2 * i
        }
        return res
    }
}