package leetcode.problems.array.easy

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

class KidsWithCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val output = BooleanArray(candies.size)
        val max = candies.max()!! // 2 <= candies.length <= 100
        candies.forEachIndexed { index, value ->
            output[index] = value + extraCandies >= max
        }
        return output
    }
}