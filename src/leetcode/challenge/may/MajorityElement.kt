package leetcode.challenge.may

import kotlin.math.floor

// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
// https://leetcode.com/submissions/detail/335238735/?from=/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        var counter = 0.0
        nums.forEach {
            map[it] = map[it]?.plus(1) ?: 1
            counter++
        }
        counter /= 2
        return map.entries.first { it.value > counter }.key
    }
}


fun main() {
    println(MajorityElement().majorityElement(intArrayOf(3, 2, 3))) // 3
    println(MajorityElement().majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2))) // 2
}