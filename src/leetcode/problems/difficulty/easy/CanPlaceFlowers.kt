package leetcode.problems.difficulty.easy

/**
 * 605. Can Place Flowers
 *
 * https://leetcode.com/problems/can-place-flowers
 */
class CanPlaceFlowers {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (n == 0) return true
        var count = n
        for (i in 0..flowerbed.lastIndex) {
            if (flowerbed[i] == 0) {
                val noPrevPlant = if (i == 0) true else flowerbed[i - 1] == 0
                val noAfterPlant = if (i == flowerbed.lastIndex) true else flowerbed[i + 1] == 0
                if (noPrevPlant && noAfterPlant) {
                    flowerbed[i] = 1
                    count--
                }
                if (count == 0) return true
            }
        }
        return false
    }
}