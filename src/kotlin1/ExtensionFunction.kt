package kotlin1

fun <T> T.println() {
    when (this) {
        is IntArray -> println((this as IntArray).asList())
        else -> println(this)
    }
}

fun main() {
    IntArray(3).println()
    "string".println()
    123.println()
}