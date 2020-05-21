package leetcode.challenge.may

// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/
// https://leetcode.com/submissions/detail/342459032/?from=/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/
class KthSmallestBST {

    private lateinit var array: MutableList<Int>
    private var k = 0

    fun kthSmallest(root: TreeNode, k: Int): Int {
        array = mutableListOf()
        this.k = k
        kthSmallest(root)
        println(array)
        return array[k - 1]
    }

    private fun kthSmallest(node: TreeNode?) {
        if (node == null) return
        if (array.size >= k) return
        kthSmallest(node.left)
        println("size: ${array.size}")
        println(node.`val`)
        array.add(node.`val`)
        if (array.size == k) {
            return
        }
        kthSmallest(node.right)
    }
}

fun main() {
    val instance = KthSmallestBST()
    val root = TreeNode(5).apply {
        left = TreeNode(3).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
            }
            right = TreeNode(4)
        }
        right = TreeNode(6)
    }
    println(instance.kthSmallest(root, 3))
}



