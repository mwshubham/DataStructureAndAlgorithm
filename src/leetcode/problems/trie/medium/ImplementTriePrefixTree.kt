package leetcode.problems.trie.medium

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/
 */
class TrieNode(
    val char: Char,
    var endsHere: Boolean?,
    val children: Array<TrieNode?>
)

/**
 * Runtime: 320 ms, faster than 100.00% of Kotlin online submissions for Implement Trie (Prefix Tree).
 * Memory Usage: 51.2 MB, less than 78.26% of Kotlin online submissions for Implement Trie (Prefix Tree).
 */
class Trie {

    val root = TrieNode('/', null, Array(26) { null })

    fun insert(word: String) {
        var trieNode = root
        word.forEach {
            if (trieNode.children[it - 'a'] == null) {
                trieNode.children[it - 'a'] = TrieNode(it, null, Array(26) { null })
            }
            trieNode = trieNode.children[it - 'a']!!
        }
        trieNode.endsHere = true
    }

    fun search(word: String): Boolean {
        var trieNode = root
        word.forEach {
            if (trieNode.children[it - 'a'] == null) {
                return false
            }
            trieNode = trieNode.children[it - 'a']!!
        }
        return trieNode.endsHere == true
    }

    fun startsWith(prefix: String): Boolean {
        var trieNode = root
        prefix.forEach {
            if (trieNode.children[it - 'a'] == null) {
                return false
            }
            trieNode = trieNode.children[it - 'a']!!
        }
        return true
    }

}