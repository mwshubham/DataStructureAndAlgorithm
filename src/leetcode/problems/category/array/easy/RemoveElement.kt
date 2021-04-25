package leetcode.problems.category.array.easy

import kotlin1.println

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/
 * https://leetcode.com/explore/featured/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
 *
 * https://leetcode.com/submissions/detail/484968668/?from=explore&item_id=3247
 */
//[3,2,2,3]
//3
//[0,1,2,2,3,0,4,2]
//2
//[1]
//1
//[1]
//2
//[3,3,3,3]
//3
//[0,4,4,0,4,4,4,0,2]
//4
class RemoveElement {
    companion object {
        /**
         * Runtime: 172 ms, faster than 55.38% of Kotlin online submissions for Remove Element.
         * Memory Usage: 36.3 MB, less than 11.38% of Kotlin online submissions for Remove Element.
         */
        fun removeElement(nums: IntArray, `val`: Int): Int {
            var ans = 0
            var front = 0
            var rear = nums.lastIndex
            while (rear >= 0 && nums[rear] == `val`) {
                rear--
                ans++
            }
            while (front < rear) {
                if (nums[front] == `val`) {
                    val temp = nums[front]
                    nums[front] = nums[rear]
                    nums[rear] = temp
                    rear--
                    ans++
                    while (rear >= 0 && nums[rear] == `val`) {
                        rear--
                        ans++
                    }
                }
                front++
            }
            return nums.size - ans
        }
    }
}

fun main() {
    RemoveElement.removeElement(intArrayOf(3, 2, 2, 3), 3).println()
}