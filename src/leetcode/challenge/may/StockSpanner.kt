package leetcode.challenge.may

import java.util.*


// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/
// https://www.geeksforgeeks.org/the-stock-span-problem/
// https://leetcode.com/submissions/detail/342009102/?from=/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/
class StockSpanner {

    private var count: Int = -1
    private val stack = Stack<Int>()
    private val priceArr = mutableListOf<Int>()

    fun next(price: Int): Int {
        count += 1
        priceArr.add(price)
        if (count == 0) {
            stack.push(0)
            return 1
        } else {
            while (stack.isNotEmpty() && priceArr[stack.peek()] <= price) {
                stack.pop()
            }

            val result = if (stack.isEmpty()) count + 1 else count - stack.peek()
            stack.push(count)
            return result
        }
    }


    // sample 504 ms submission
//    val list = ArrayList<IntArray>()
//
//    fun next(price: Int): Int {
//        var i = list.lastIndex
//        var count = 1
//        while (i >= 0) {
//            val array = list[i]
//            val value = array[0]
//            val amount = array[1]
//            if(value > price) {
//                break
//            } else {
//                i -= amount
//            }
//        }
//        val curAmount = list.size - i
//        list.add(intArrayOf(price, curAmount))
//        return curAmount
//    }
}

fun main() {
    val instance = StockSpanner()
    println(instance.next(100))
    println(instance.next(80))
    println(instance.next(60))
    println(instance.next(70))
    println(instance.next(60))
    println(instance.next(75))
    println(instance.next(85))
}
