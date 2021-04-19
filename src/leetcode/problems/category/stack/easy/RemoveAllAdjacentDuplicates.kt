package leetcode.problems.category.stack.easy

class RemoveAllAdjacentDuplicates {
    /**
     * With Stack
     *  Runtime: 276 ms, faster than 86.67% of Kotlin online submissions for Remove All Adjacent Duplicates In String.
     *  Memory Usage: 35.5 MB, less than 80.00% of Kotlin online submissions for Remove All Adjacent Duplicates In String.
     */
//    fun removeDuplicates(S: String): String {
//        val stack = Stack<Char>()
//        S.forEach {
//            if (stack.isNotEmpty() && stack.peek() == it) {
//                stack.pop()
//            } else {
//                stack.push(it)
//            }
//        }
//        val stringBuilder = StringBuilder()
//        stack.forEach { stringBuilder.append(it) }
//        return stringBuilder.toString()
//    }

    /**
     * Without Stack
     * Runtime: 196 ms, faster than 100.00% of Kotlin online submissions for Remove All Adjacent Duplicates In String.
     * Memory Usage: 34.3 MB, less than 100.00% of Kotlin online submissions for Remove All Adjacent Duplicates In String.
     */
    fun removeDuplicates(S: String): String {
        val sb = StringBuilder()
        for (c in S.toCharArray()) {
            val size = sb.length
            if (size > 0 && sb[size - 1] == c) {
                sb.deleteCharAt(size - 1)
            } else {
                sb.append(c)
            }
        }
        return sb.toString()
    }
}