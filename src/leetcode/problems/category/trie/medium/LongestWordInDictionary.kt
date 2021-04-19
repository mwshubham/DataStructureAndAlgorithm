package leetcode.problems.category.trie.medium

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */
//["w","wo","wor","worl","world"]
//["a","banana","app","appl","ap","apply","apple"]
class LongestWordInDictionary {
    class TrieNode(
        var word: String,
        @Suppress("MemberVisibilityCanBePrivate")
        val children: Array<TrieNode?>
    )

    fun findLongestWord(node: TrieNode): String {
        var res = node.word
        node.children.forEach { childNode ->
            if (childNode != null && childNode.word.isNotEmpty()) {
                val childWord = findLongestWord(childNode)
                if (childWord.length > res.length || (childWord.length == res.length && childWord < res)) {
                    res = childWord
                }
            }

        }
        return res
    }

    /**
     * Runtime: 224 ms, faster than 74.29% of Kotlin online submissions for Longest Word in Dictionary.
     * Memory Usage: 37 MB, less than 57.14% of Kotlin online submissions for Longest Word in Dictionary.
     */
    fun longestWord(words: Array<String>): String {
        if (words.isEmpty()) return ""
        val root = TrieNode("", Array(26) { null })
        words.forEach { word ->
            var node = root
            word.forEach { char ->
                if (node.children[char - 'a'] == null) {
                    node.children[char - 'a'] = TrieNode("", Array(26) { null })
                }
                node = node.children[char - 'a']!!
            }
            node.word = word
        }
        return findLongestWord(root)
    }
}