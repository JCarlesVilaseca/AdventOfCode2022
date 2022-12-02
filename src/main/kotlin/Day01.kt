class Day01(private val input: String) {
    private fun sum(n: Int): Int {
        return input
            .split("\r\n\r\n")
            .map { it.split("\r\n").map { it.toInt() } }
            .map { it.sum() }
            .sortedDescending()
            .take(n)
            .sum()
    }

    fun part1(): String {
        return sum(1).toString()
    }

    fun part2(): String {
        return sum(3)
            .toString()
    }
}

fun main() {
    val fileContent = Day01::class.java.getResource("Day01.txt")?.readText()

    check(fileContent != null)

    val day = Day01(fileContent)

    println("Part 1: ${day.part1()}")
    println("Part 2: ${day.part2()}")
}
