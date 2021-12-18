package leetcode.problems.difficulty.medium

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/794/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/794/
 * https://leetcode.com/submissions/detail/603513384/?from=explore&item_id=794
 */
class GenerateParentheses {

    companion object {
        private const val PARENTHESES_OPEN = "("
        private const val PARENTHESES_CLOSE = ")"

        /**
         * Runtime: 168 ms, faster than 81.57% of Kotlin online submissions for Generate Parentheses.
         * Memory Usage: 35.9 MB, less than 80.18% of Kotlin online submissions for Generate Parentheses.
         */
        fun generateParenthesis(n: Int): List<String> {
            val res = ArrayList<String>()
            generateParenthesis(res, "", 0, 0, n)
            return res
        }

        private fun generateParenthesis(res: ArrayList<String>, str: String, open: Int, close: Int, n: Int) {
            if (str.length == n * 2) {
                res.add(str)
                return
            }
            if (open < n) generateParenthesis(res, str + PARENTHESES_OPEN, open + 1, close, n)
            if (close < open) generateParenthesis(res, str + PARENTHESES_CLOSE, open, close + 1, n)
        }
    }
}