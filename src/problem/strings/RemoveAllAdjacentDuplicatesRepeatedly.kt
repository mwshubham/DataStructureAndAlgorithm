package problem.strings

// todo
// https://leetcode.com/problems/reorganize-string/solution/
// https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/
class RemoveAllAdjacentDuplicatesRepeatedly {

    fun removeDuplicates(inputString: String): String {
//        var charArray = inputString.toCharArray()
//        var lastKnownChar: Char? = null
//        val result = StringBuilder()
//        while (true) {
//            lastKnownChar = null
//            tempString.toCharArray().forEach { char ->
//                if (char != lastKnownChar) {
//                    result.append(char)
//                    lastKnownChar = char
//                }
//            }
//        }
//
        return inputString
    }
}

fun main() {
    val instance = RemoveAllAdjacentDuplicatesRepeatedly()
    instance.removeDuplicates("abbaca")
}
