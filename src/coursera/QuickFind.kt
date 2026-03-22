package coursera

/**
 * https://www.coursera.org/learn/algorithms-part1/lecture/EcF3P/quick-find
 *
 * Complexity:
 *
 * Initialization: O(N)
 * Union: O(N)
 * Find: O(1)
 *
 *
 * Union is too expensive. It takes N square (quadratic) array accesses to process a sequence of
 * N union commands on N objects.
 */
class QuickFind(
    val count: Int,
) {

    val items = Array(count) { it }

    fun union(p: Int, q: Int) {
        val pid = items[p]
        items.forEachIndexed { index, item ->
            if (item == pid) {
                items[index] = items[q]
            }
        }
    }

    fun connected(p: Int, q: Int): Boolean {
        return items[p] == items[q]
    }
}


fun main() {
    val quickFind = QuickFind(9)

    // Initial state: each element is in its own component
    println("Initial state:")
    for (i in 0 until 9) {
        print("${quickFind.items[i]} ")
    }
    println("\n")

    // Test connections before any unions
    println("Testing initial connections:")
    println("0 and 1 connected: ${quickFind.connected(0, 1)}")
    println("2 and 3 connected: ${quickFind.connected(2, 3)}")
    println()

    // Union some elements
    println("Performing unions...")
    quickFind.union(0, 1)
    println("After union(0, 1):")
    for (i in 0 until 9) {
        print("${quickFind.items[i]} ")
    }
    println()

    quickFind.union(2, 3)
    println("After union(2, 3):")
    for (i in 0 until 9) {
        print("${quickFind.items[i]} ")
    }
    println()

    quickFind.union(1, 2)
    println("After union(1, 2):")
    for (i in 0 until 9) {
        print("${quickFind.items[i]} ")
    }
    println("\n")

    // Test connections after unions
    println("Testing connections after unions:")
    println("0 and 1 connected: ${quickFind.connected(0, 1)}")
    println("0 and 2 connected: ${quickFind.connected(0, 2)}")
    println("0 and 3 connected: ${quickFind.connected(0, 3)}")
    println("1 and 3 connected: ${quickFind.connected(1, 3)}")
    println("4 and 5 connected: ${quickFind.connected(4, 5)}")
    println("0 and 4 connected: ${quickFind.connected(0, 4)}")

    println("\nFinal state:")
    for (i in 0 until 9) {
        print("${quickFind.items[i]} ")
    }
    println()
}