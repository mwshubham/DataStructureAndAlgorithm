package afteracademy

import BinaryTree

// https://afteracademy.com/blog/what-is-the-two-pointer-technique
// Min Depth of Binary Tree
// Problem description: Given a binary tree, find its minimum depth.


lateinit var tree: BinaryTree

fun main() {
    tree = BinaryTree()
    tree.traverse()
    tree.insert(1)
    tree.insert(2)
    tree.insert(3)
    tree.insert(4)
    tree.insert(5)
    tree.insert(6)
    tree.insert(7)
    tree.traverse()
}

