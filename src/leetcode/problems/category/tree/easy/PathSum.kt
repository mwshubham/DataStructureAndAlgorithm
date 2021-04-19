package leetcode.problems.category.tree.easy

import leetcode.problems.difficulty.TreeNode

class PathSum {

    companion object {
        /**
         * Runtime: 168 ms, faster than 97.67% of Kotlin online submissions for Path Sum.
         * Memory Usage: 35.5 MB, less than 41.86% of Kotlin online submissions for Path Sum.
         */
        fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
            try {
                hasPathSum(root, targetSum, 0)
            } catch (e: Exception) {
                return true
            }

            return false
        }

        @Throws(Exception::class)
        private fun hasPathSum(root: TreeNode?, targetSum: Int, pathSum: Int) {
            root ?: return
            if (root.left == null && root.right == null) {
                if (targetSum == pathSum + root.`val`) {
                    throw Exception("Has Path Sum")
                }
            }
            hasPathSum(root.left, targetSum, pathSum + root.`val`)
            hasPathSum(root.right, targetSum, pathSum + root.`val`)
        }

        /**
         * Runtime: 176 ms, faster than 80.62% of Kotlin online submissions for Path Sum.
         * Memory Usage: 35.2 MB, less than 60.47% of Kotlin online submissions for Path Sum.
         */
        fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {
            root ?: return false
            if (root.left == null && root.right == null && targetSum == root.`val`) {
                return true
            }
            return hasPathSum(root.left, targetSum - root.`val`)
                    || hasPathSum(root.right, targetSum - root.`val`)
        }

    }
}