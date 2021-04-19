package leetcode.problems.category.array.easy

class ToLowerCase {
    fun toLowerCase(str: String): String {
        val sb = StringBuilder()
        str.forEach { char ->
            if (char.toInt() in 65..90) {
                sb.append(char + 32)
            } else {
                sb.append(char)
            }
        }
        return sb.toString()
    }
}

fun main() {
    println(ToLowerCase().toLowerCase("Hello"))
}
