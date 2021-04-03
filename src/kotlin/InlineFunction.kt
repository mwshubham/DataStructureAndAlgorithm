package kotlin

fun main() {
    inlineFunction(
        abc = {
            println("abc")
            return
        },
        xyz = {
            println("xyz")
        }
    )
    normalFunction()
}

fun normalFunction() {
    println("Inside Normal Function")
}

inline fun inlineFunction(
    abc: () -> Unit,
    xyz: () -> Unit
) {
    println("Inside Inline Function")
    abc()
    xyz()
}
