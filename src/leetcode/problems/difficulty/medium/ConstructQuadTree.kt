package leetcode.problems.difficulty.medium

/**
 * 427. Construct Quad Tree
 * https://leetcode.com/problems/construct-quad-tree/
 */
class ConstructQuadTree {

    companion object {
        fun construct(grid: Array<IntArray>): Node? {
            return construct(grid, 0, 0, grid.size)
        }

        @Suppress("RedundantNullableReturnType")
        fun construct(grid: Array<IntArray>, x: Int, y: Int, length: Int): Node? {
            if (length == 1) {
                return Node(grid[x][y] == 1, true)
            }
            val node = Node(`val` = false, isLeaf = false)
            val topLeft = construct(grid, x, y, length / 2)!!
            val topRight = construct(grid, x, y + length / 2, length / 2)!!
            val bottomLeft = construct(grid, x + length / 2, y, length / 2)!!
            val bottomRight = construct(grid, x + length / 2, y + length / 2, length / 2)!!
            if (topLeft.isLeaf && topRight.isLeaf
                && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.`val` == topRight.`val`
                && topRight.`val` == bottomLeft.`val`
                && bottomLeft.`val` == bottomRight.`val`
            ) {
                node.isLeaf = true
                node.`val` = topLeft.`val`
            } else {
                node.topLeft = topLeft
                node.topRight = topRight
                node.bottomLeft = bottomLeft
                node.bottomRight = bottomRight
            }
            return node
        }
    }

    /**
     * Definition for a QuadTree node.
     */
    class Node(var `val`: Boolean, var isLeaf: Boolean) {
        var topLeft: Node? = null
        var topRight: Node? = null
        var bottomLeft: Node? = null
        var bottomRight: Node? = null
    }
}

