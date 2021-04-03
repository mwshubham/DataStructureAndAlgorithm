package kotlin1

fun main() {
    inlineFunction(
        abc = {
            println("abc")
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
    noinline abc: () -> Unit,
    crossinline xyz: () -> Unit
) {
    println("Inside Inline Function")
    abc()
    xyz()
}
