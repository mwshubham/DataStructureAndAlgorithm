package leetcode.problems.trie.medium

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/
 */
class TrieNode(
    val char: Char,
    var isWord: Boolean?,
    val children: Array<TrieNode?>
)

/**
 * Runtime: 320 ms, faster than 100.00% of Kotlin online submissions for Implement Trie (Prefix Tree).
 * Memory Usage: 51.2 MB, less than 78.26% of Kotlin online submissions for Implement Trie (Prefix Tree).
 */
class Trie {

    val root = TrieNode('/', null, Array(26) { null })

    fun insert(word: String) {
        var node = root
        word.forEach {
            if (node.children[it - 'a'] == null) {
                node.children[it - 'a'] = TrieNode(it, null, Array(26) { null })
            }
            node = node.children[it - 'a']!!
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        word.forEach {
            if (node.children[it - 'a'] == null) {
                return false
            }
            node = node.children[it - 'a']!!
        }
        return node.isWord == true
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        prefix.forEach {
            if (node.children[it - 'a'] == null) {
                return false
            }
            node = node.children[it - 'a']!!
        }
        return true
    }

}