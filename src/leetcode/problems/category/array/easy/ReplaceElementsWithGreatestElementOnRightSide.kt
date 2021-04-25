package leetcode.problems.category.array.easy

import kotlin.math.max

/**
 * 1299. Replace Elements with Greatest Element on Right Side
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
 *
 * https://leetcode.com/submissions/detail/484998257/?from=explore&item_id=3259
 */
class ReplaceElementsWithGreatestElementOnRightSide {
    /**
     * Runtime: 268 ms, faster than 43.21% of Kotlin online submissions for Replace Elements with Greatest Element on Right Side.
     * Memory Usage: 40 MB, less than 23.46% of Kotlin online submissions for Replace Elements with Greatest Element on Right Side.
     */
    companion object {
        fun replaceElements(arr: IntArray): IntArray {
            var max = -1
            for (i in arr.lastIndex downTo 0) {
                val curr = arr[i]
                arr[i] = max
                max = max(curr, max)
            }
            return arr
        }
    }
}