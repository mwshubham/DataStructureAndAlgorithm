package leetcode.problems.category.trie.medium


/**
 *
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 *
 * Runtime: 396 ms, faster than 74.07% of Kotlin online submissions for Design Add and Search Words Data Structure.
 * Memory Usage: 61.9 MB, less than 48.15% of Kotlin online submissions for Design Add and Search Words Data Structure.
 */
//["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
//[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
//["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
class WordDictionary {

    val root = TrieNode('/', null, Array(26) { null })

    fun addWord(word: String) {
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
        return search(word, 0, root)
    }

    fun search(word: String, pos: Int, node: TrieNode): Boolean {
        if (word.length == pos) return true
        if (word[pos] == '.') {
            node.children.forEach { childNode ->
                childNode?.let {
                    return search(word, pos + 1, childNode)
                }
            }
        } else {
            if (node.children[word[pos] - 'a'] == null) {
                return false
            }
            return search(word, pos + 1, node.children[word[pos] - 'a']!!)
        }
        return false
    }
}