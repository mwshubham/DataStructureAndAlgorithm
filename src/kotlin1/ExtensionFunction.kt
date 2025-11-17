package kotlin1

fun <T> T.println() {
    when (this) {
        is Array<*> -> this.toList().println()
        is IntArray -> println((this as IntArray).asList())
        else -> println(this)
    }
}

fun main() {
    IntArray(3).println()
    "string".println()
    123.println()
    listOf(1, 2, 3).println()
    Array(4) { 3 }.println()
    Array(4) { "" }.println()
    Array(4) { 1.0 }.println()
}