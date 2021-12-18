package leetcode.problems.difficulty.medium

import java.util.*

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/
 * https://leetcode.com/submissions/detail/603522507/?from=explore&item_id=795
 */
class Permutations {

    companion object {
        /**
         * Runtime: 200 ms, faster than 85.38% of Kotlin online submissions for Permutations.
         * Memory Usage: 36.2 MB, less than 97.23% of Kotlin online submissions for Permutations.
         */
        fun permute(nums: IntArray): List<List<Int>> {
            val res = LinkedList<LinkedList<Int>>()
            nums.forEach { num ->
                res.add(
                    LinkedList<Int>().apply {
                        add(num)
                    }
                )
            }
            while (res.peek().size != nums.size) {
                val firstArr = res.removeFirst()
                nums.forEach { num ->
                    if (!firstArr.contains(num)) {
                        res.addLast(
                            LinkedList<Int>().apply {
                                addAll(firstArr)
                                add(num)
                            }
                        )
                    }
                }
            }
            return res
        }
    }
}