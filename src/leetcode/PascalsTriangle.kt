package leetcode

/**
 * https://leetcode.com/problems/pascals-triangle/
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/601/
 * https://leetcode.com/submissions/detail/597159356/?from=explore&item_id=601
 */
class PascalsTriangle {
    companion object {
        /**
         * Runtime: 160 ms, faster than 53.36% of Kotlin online submissions for Pascal's Triangle.
         * Memory Usage: 35.4 MB, less than 57.40% of Kotlin online submissions for Pascal's Triangle.
         */
        fun generate(numRows: Int): List<List<Int>> {
            val res = ArrayList<ArrayList<Int>>()
            res.add(ArrayList<Int>().apply { add(1) })
            for (i in 1 until numRows) {
                val list = ArrayList<Int>()
                for (j in 0..i) {
                    val a = res.getOrNull(i - 1)?.getOrNull(j - 1) ?: 0
                    val b = res.getOrNull(i - 1)?.getOrNull(j) ?: 0
                    list.add(a + b)
                }
                res.add(list)
            }
            return res
        }
    }
}