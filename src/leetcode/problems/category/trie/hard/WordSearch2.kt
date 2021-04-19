package leetcode.problems.category.trie.hard

import java.util.*


class TrieNode {
    var children = arrayOfNulls<TrieNode>(26)
    var word: String? = null
}

/**
 * https://leetcode.com/problems/word-search-ii/
 */

class WordSearch2 {
    companion object {

        /**
         * Runtime: 252 ms, faster than 75.44% of Kotlin online submissions for Word Search II.
        Memory Usage: 36.2 MB, less than 82.46% of Kotlin online submissions for Word Search II.

         */
        fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
            val res = ArrayList<String>()
            val root = buildTrie(words)
            for (i in board.indices) {
                for (j in board[0].indices) {
                    dfs(board, i, j, root, res)
                }
            }
            return res
        }

        private fun dfs(board: Array<CharArray>, i: Int, j: Int, node: TrieNode, res: ArrayList<String>) {
            var _node = node
            val char = board[i][j]
            if (char == '#' || _node.children[char - 'a'] == null) return
            _node = _node.children[char - 'a']!!
            if (_node.word != null) {
                // found one
                res.add(_node.word!!)
                // de-duplicate
                _node.word = null
            }
            board[i][j] = '#'
            if (i > 0) dfs(board, i - 1, j, _node, res)
            if (j > 0) dfs(board, i, j - 1, _node, res)
            if (i < board.size - 1) dfs(board, i + 1, j, _node, res)
            if (j < board[0].size - 1) dfs(board, i, j + 1, _node, res)
            board[i][j] = char
        }

        private fun buildTrie(words: Array<String>): TrieNode {
            val root = TrieNode()
            for (word in words) {
                var node = root
                for (char in word.toCharArray()) {
                    val index = char - 'a'
                    if (node.children[index] == null) node.children[index] = TrieNode()
                    node = node.children[index]!!
                }
                node.word = word
            }
            return root
        }
    }
}