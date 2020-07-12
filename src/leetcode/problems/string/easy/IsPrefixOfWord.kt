package leetcode.problems.string.easy

class IsPrefixOfWord {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        val words = sentence.split(" ")
        for (i in 0..words.lastIndex) {
            if (words[i].startsWith(searchWord)) {
                return i + 1
            }
        }
        return -1
    }

    fun isPrefixOfWord2(sentence: String, searchWord: String): Int {
        var word = 1
        var isNewWord = true

        var counter = 0
        while (counter < sentence.length) {
            if (sentence[counter] == ' ') {
                isNewWord = true
                word++
                counter++
            } else if (isNewWord) {
                println("isNewWord: $isNewWord")
                var searchWordCounter = 0
                while (searchWordCounter < searchWord.length && counter < sentence.length && searchWord[searchWordCounter] == sentence[counter]) {
                    searchWordCounter++
                    counter++
                    println("searchWordCounter: $searchWordCounter")
                    println("counter: $counter")
                }
                if (searchWordCounter == searchWord.length) {
                    return word
                }
                isNewWord = false
            } else {
                isNewWord = false
                counter++
            }

        }

        return -1
    }

}

//"b bu bur burg burger"
//"burg"

//"hellohello hellohellohello"
//"ell"

//"i love eating burger"
//"burg"

//"this problem is an easy problem"
//"pro"