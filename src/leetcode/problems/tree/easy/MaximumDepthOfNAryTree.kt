package leetcode.problems.tree.easy

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
class MaximumDepthOfNAryTree {
    /**
     * Runtime: 192 ms, faster than 60.00% of Kotlin online submissions for Maximum Depth of N-ary Tree.
     * Memory Usage: 38.5 MB, less than 32.00% of Kotlin online submissions for Maximum Depth of N-ary Tree.
     */
    fun maxDepth(root: Node?): Int {
        if (root == null) return 0
        var height = 0
        root.children.forEach {
            height = max(height, maxDepth(it))
        }
        return 1 + height
    }
}