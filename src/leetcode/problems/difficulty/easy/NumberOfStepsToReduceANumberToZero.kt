package leetcode.problems.difficulty.easy

/**
 * 1342. Number of Steps to Reduce a Number to Zero
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/#:~:text=Given%20an%20integer%20num%20%2C%20return,by%202%20and%20obtain%207.
 * Constraints:
 * 0 <= num <= 106
 */
class NumberOfStepsToReduceANumberToZero {

    companion object{
        /**
         * Runtime: 144 ms, faster than 31.48% of Kotlin online submissions for Number of Steps to Reduce a Number to Zero.
         * Memory Usage: 32.8 MB, less than 88.89% of Kotlin online submissions for Number of Steps to Reduce a Number to Zero.
         */
        fun numberOfSteps(num: Int): Int {
            if(num == 0) return 0
            var res = 0
            var num = num
            while (num != 0){
                // In order to count steps when right shifting one digit
                // For odd: we will subtract and divide by 2, which takes 2 steps
                // For even: we just divide by 2, which takes 1 step
                res += if (num and 1 == 0) 1 else 2
                num = num shr 1
            }
            // We subtract 1 from result because when we the get to the most significant 1,
            // we only need to subtract it and we no longer need to divide by 2, so
            // only 1 step needed instead of the 2 that we counted when using the above while loop
            return --res
        }
    }
}