package gfg

/**
 * AutoCompleteTrie provides functionality to suggest words based on a given prefix
 * https://www.geeksforgeeks.org/dsa/auto-complete-feature-using-trie/
 * https://leetcode.com/discuss/post/5273663/adobe-noida-85-yrs-cs2-rejected-by-anony-lym0/
 */
private class TrieNode {
    var isEndOfWord: Boolean = false
    val children: MutableMap<Char, TrieNode> = mutableMapOf()

    fun insert(word: String) {
        var currentNode = this
        for (char in word) {
            currentNode = currentNode.children.getOrPut(char) { TrieNode() }
        }
        currentNode.isEndOfWord = true
    }

    fun getSuggestions(prefix: String): List<String> {
        val suggestions = mutableListOf<String>()
        var currentNode: TrieNode? = this
        prefix.forEach { char ->
            currentNode?.children?.get(char)?.let {
                currentNode = it
            }
        }
        getAllWordsFromNode(
            prefix = prefix,
            node = currentNode ?: return suggestions,
            suggestions = suggestions
        )
        return suggestions
    }

    fun getAllWordsFromNode(prefix: String, node: TrieNode, suggestions: MutableList<String>) {
        if (node.isEndOfWord) {
            suggestions.add(prefix)
        }
        node.children.forEach { (char, node) ->
            getAllWordsFromNode(prefix + char, node, suggestions)
        }
    }
}

class AutoCompleteTrie {
    companion object {
        fun autoComplete(words: List<String>, prefix: String): List<String> {
            if (words.isEmpty()) return emptyList()
            // Build the Trie
            val root = TrieNode()
            words.forEach { root.insert(it) }
            return root.getSuggestions(prefix)
        }
    }
}


fun main() {
    val words = listOf("apple", "app", "apricot", "banana", "bat", "ball")
    val prefixList = listOf("ap", "ba", "a", "b", "banana", "")
    prefixList.forEach { prefix ->
        val results = AutoCompleteTrie.autoComplete(words, prefix)
        println("Words with prefix '$prefix': $results")
    }
}