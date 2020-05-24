package leetcode.challenge.may

import java.util.*


// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/
// https://leetcode.com/submissions/detail/337870562/?from=/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/
class FloodFill {

    val stack = Stack<Pair<Int, Int>>()
    var changeColor: Int = -1
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        changeColor = image[sr][sc]
        image[sr][sc] = newColor

        stack.push(Pair(sr, sc))
        while (stack.isNotEmpty()) {
            getMatrix(image)
        }
        formatOutput(image, newColor)
        return image
    }

    fun getMatrix(image: Array<IntArray>) {
        println()
        println()
        println()


        val pair = stack.pop()
        val sr = pair.first
        val sc = pair.second
        println("[sr,sc]:[$sr,$sc]")

        image.forEachIndexed { index, array ->
            println("image[$index]: ${array.joinToString()}")
        }


        val columnSize = image[0].size
        val rowSize = image.size

        // left exist
        if (sc != 0 && image[sr][sc - 1] == changeColor && image[sr][sc - 1] != -1) {
            image[sr][sc - 1] = -1
            stack.add(Pair(sr, sc - 1))
        }

        // top exist
        if (sr != 0 && image[sr - 1][sc] == changeColor && image[sr - 1][sc] != -1) {
            image[sr - 1][sc] = -1
            stack.add(Pair(sr - 1, sc))
        }

        // right exist
        if (sc != columnSize - 1 && image[sr][sc + 1] == changeColor && image[sr][sc + 1] != -1) {
            image[sr][sc + 1] = -1
            stack.add(Pair(sr, sc + 1))
        }

        // bottom exist
        if (sr != rowSize - 1 && image[sr + 1][sc] == changeColor && image[sr + 1][sc] != -1) {
            image[sr + 1][sc] = -1
            stack.add(Pair(sr + 1, sc))
        }
    }

    fun formatOutput(image: Array<IntArray>, newColor: Int) {
        image.forEachIndexed { indexRow, columns ->
            columns.forEachIndexed { indexColumn, columnValue ->
                if (columnValue == -1) {
                    image[indexRow][indexColumn] = newColor
                }
            }
        }
    }
}

//[[0,0,0],[0,0,0]]
//0
//0
//2

fun main() {
    val instance = FloodFill()
    instance.floodFill(
        arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        ),
        1,
        1,
        2
    )
        .forEachIndexed { index, array ->
            println("image[$index]: ${array.joinToString()}")
        }
}