package facebook

class TwoDimensionalSpiralArray {

    fun main() {
        val input = 3
        println(input)
        val arr = Array(input) { Array(input) { 0 } }
        arr.forEach { println(it.asList()) }
        // R B L T
        val arrRow = intArrayOf(0, 1, 0, -1)
        val arrCol = intArrayOf(1, 0, -1, 0)

        var count = 1
        val max = input * input
        var direction = 0
        var row = 0
        var col = 0
        while (count <= max) {
            if (isValid(arr, row, col)) {
                arr[row][col] = count++
                row += arrRow[direction]
                col += arrCol[direction]
            } else {
                row -= arrRow[direction]
                col -= arrCol[direction]
                direction = (direction + 1) % 4
                row += arrRow[direction]
                col += arrCol[direction]
            }
        }
        arr.forEach { println(it.asList()) }
    }

    private fun isValid(arr: Array<Array<Int>>, row: Int, col: Int): Boolean {
        return row in arr.indices && col in arr.first().indices && arr[row][col] == 0
    }
}