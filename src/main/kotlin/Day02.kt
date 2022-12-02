import java.security.InvalidParameterException

class Day02(private val input: List<String>) {

    private fun String.toValue(): Int {
        when (this) {
            "X","C" -> return 0
            "Y","B" -> return 1
            "Z","A" -> return 2
        }
        throw InvalidParameterException()
    }

    fun part1(): String {
        return input.map {
            it
                .split(" ")
                .map { it.toValue() }
                .let { it[0] to it[1] } }
            .sumOf { (6 + (it.second * 4) + it.first * 3) % 9 + 1 }
            .toString()
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
    //println("Part 2: ${day.part2()}")
}
