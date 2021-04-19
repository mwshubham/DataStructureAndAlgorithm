package leetcode.problems.category.array.easy

class SubtractProductAndSum {
    //  1 <= n <= 10^5
    fun subtractProductAndSum(n: Int): Int {
        @Suppress("NAME_SHADOWING")
        var n = n
        var product = 1
        var sum = 0
        while (n != 0) {
            n.rem(10).let {
                product *= it
                sum += it
            }
            n /= 10
        }
        return product - sum
    }
}

fun main() {
    println(SubtractProductAndSum().subtractProductAndSum(100))
}