package searching

val intArray: IntArray = intArrayOf(1, 4, 6, 8, 9, 10)

fun main() {
    binarySearch(8)
    binarySearch(4)
    binarySearch(5)
    binarySearch(6)
    binarySearch(1)
    binarySearch(10)
}

fun binarySearch(itemToSearch: Int) {
    println("Search $itemToSearch")
    var left = 0
    var right = intArray.lastIndex
    while (right >= left) {
        val mid = left + (right - left) / 2
        if (intArray[mid] == itemToSearch) {
            return println("Item [$itemToSearch] is present at position -> $mid")
        } else if (intArray[mid] < itemToSearch) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return println("Item [$itemToSearch] is not present.")
}