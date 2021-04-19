package leetcode.problems.category.array.easy

class NumOfStepsToZero {
    fun numberOfSteps(num: Int): Int {
        var steps = 0
        var n = num
        while (n != 0) {
            if (n % 2 != 0) {
                n--
                steps++
            }
            if (n == 0) {
                break
            }
            n /= 2
            steps++
        }
        return steps
    }
}