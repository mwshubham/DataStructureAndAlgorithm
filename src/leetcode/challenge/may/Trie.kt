package leetcode.challenge.may

// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/
class Trie {
    val set = mutableSetOf<String>()

    fun insert(word: String) {
        set.add(word)
    }

    fun search(word: String): Boolean {
        return set.contains(word)
    }

    fun startsWith(prefix: String): Boolean {
        return set.any { it.startsWith(prefix) }
    }
}

fun main() {
    val trie = Trie()
    trie.insert("apple")
    trie.insert("apple")
    println(trie.search("apple"))   // returns true
    println(trie.search("app"))     // returns false
    println(trie.startsWith("app")) // returns true
    trie.insert("app")
    trie.search("app")
}
