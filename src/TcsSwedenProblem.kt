//import leetcode.problems.difficulty.medium.Color
//import java.lang.StringBuilder


// Credit Card Verify
//fun tcsSweden2(input: String): String {
//    if (input.length <= 1) return "Invalid"
//    var sum = 0
//    var index = 0
//    input.forEach { char ->
//        if (char.toInt() - '0'.toInt() in 0..9) {
//            sum += if (index % 2 == 0) {
//                var double = (char.toInt() - '0'.toInt()) * 2
//                if (double > 9){
//                    double -= 9
//                }
//                double
//            } else {
//                char.toInt() - '0'.toInt()
//            }
//            index++
//        }
//    }
//    if (sum % 10 == 0)
//        return "Valid"
//
//    return "Invalid"
//}


// Enum Based Problem.
//fun tcsSweden(vararg input: Color) {
//    val output = StringBuilder()
//    output.append(input[0].ordinal)
//    output.append(input[1].ordinal)
//    for (i in 0 until input[2].ordinal % 3) {
//        output.append("0")
//    }
//    val zeroFormattedInt = output.toString().toInt()
//    output.clear()
//    output.append(zeroFormattedInt)
//    output.append(" ")
//    output.append(TaskScheduler.Unit.values()[input[2].ordinal / 3].name.toLowerCase())
//    println(output.toString())
//}