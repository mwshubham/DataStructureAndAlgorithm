package coursera

/**
 * https://www.coursera.org/learn/algorithms-part1/lecture/ZgecU/quick-union
 *
 * Complexity:
 * Initialization: O(N)
 * Union: O(N) worst case (tree can get tall)
 * Find/Connected: O(N) worst case (tree can get tall)
 */
class QuickUnion(
    val count: Int
) {

    val items = Array(count) { it }

    private fun root(i: Int): Int {
        var current = i
        while (items[current] != current) {
            current = items[current]
        }
        return current
    }

    fun union(p: Int, q: Int) {
        val rootP = root(p)
        val rootQ = root(q)
        if (rootP != rootQ) {
            items[rootP] = rootQ
        }
    }

    fun connected(p: Int, q: Int): Boolean {
        return root(p) == root(q)
    }
}

fun main() {
    val quickUnion = QuickUnion(10)

    // Initial state: each element is its own root
    println("Initial state:")
    for (i in 0 until 10) {
        print("${quickUnion.items[i]} ")
    }
    println("\n")

    // Test connections before any unions
    println("Testing initial connections:")
    println("0 and 1 connected: ${quickUnion.connected(0, 1)}")
    println("2 and 3 connected: ${quickUnion.connected(2, 3)}")
    println()

    // Perform unions and show the tree structure
    println("Performing unions...")

    quickUnion.union(4, 3)
    println("After union(4, 3):")
    printState(quickUnion)

    quickUnion.union(3, 8)
    println("After union(3, 8):")
    printState(quickUnion)

    quickUnion.union(6, 5)
    println("After union(6, 5):")
    printState(quickUnion)

    quickUnion.union(9, 4)
    println("After union(9, 4):")
    printState(quickUnion)

    quickUnion.union(2, 1)
    println("After union(2, 1):")
    printState(quickUnion)

    quickUnion.union(5, 0)
    println("After union(5, 0):")
    printState(quickUnion)

    quickUnion.union(7, 2)
    println("After union(7, 2):")
    printState(quickUnion)

    quickUnion.union(6, 1)
    println("After union(6, 1):")
    printState(quickUnion)

    println("\nTesting connections after unions:")
    println("4 and 3 connected: ${quickUnion.connected(4, 3)}")
    println("3 and 8 connected: ${quickUnion.connected(3, 8)}")
    println("4 and 8 connected: ${quickUnion.connected(4, 8)}")
    println("9 and 8 connected: ${quickUnion.connected(9, 8)}")
    println("0 and 7 connected: ${quickUnion.connected(0, 7)}")
    println("1 and 6 connected: ${quickUnion.connected(1, 6)}")
    println("0 and 4 connected: ${quickUnion.connected(0, 4)}")
    println("1 and 9 connected: ${quickUnion.connected(1, 9)}")

    println("\nFinal state:")
    printState(quickUnion)

    // Show the tree structure
    println("\nTree structure (element -> parent):")
    for (i in 0 until 10) {
        if (quickUnion.items[i] == i) {
            println("$i is a root")
        } else {
            println("$i -> ${quickUnion.items[i]}")
        }
    }
}

fun printState(quickUnion: QuickUnion) {
    for (i in 0 until quickUnion.count) {
        print("${quickUnion.items[i]} ")
    }
    println()
}
