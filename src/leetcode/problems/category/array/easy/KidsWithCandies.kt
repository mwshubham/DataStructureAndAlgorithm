package leetcode.problems.category.array.easy

/**
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */
class KidsWithCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val output = BooleanArray(candies.size)
        val max = candies.max()!! // 2 <= candies.length <= 100
        candies.forEachIndexed { index, value ->
            output[index] = value + extraCandies >= max
        }
        return output
    }


    class Solution {
        fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
            val maxCandy = candies.max()
            return candies.map { it + extraCandies >= maxCandy }
        }
    }
}