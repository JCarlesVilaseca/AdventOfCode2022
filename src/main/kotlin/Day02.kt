class Day02(private val input: List<String>) {
    fun part1(): String {
        val rounds = input.map {  }
        return "1"
    }

    fun part2(): String {
        return "2"
    }
}

fun main() {
    val lines = Day01::class.java.getResource("Day02.txt")?.readText()?.lines()

    check(lines != null)

    val day = Day02(lines)

    println("Part 1: ${day.part1()}")
    println("Part 2: ${day.part2()}")
}
