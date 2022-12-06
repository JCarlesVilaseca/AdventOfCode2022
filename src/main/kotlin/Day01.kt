import kotlin.reflect.KClass

private fun part1(input: Iterable<Iterable<Int>>) =
    input
        .map { it.sum() }
        .sortedDescending()
        .take(1)
        .sum()

private fun part2(input: Iterable<Iterable<Int>>) =
    input
        .map { it.sum() }
        .sortedDescending()
        .take(1)
        .sum()

fun main() {
    val testInput = listOf(
        listOf(1000, 2000, 3000),
        listOf(4000),
        listOf(5000, 6000),
        listOf(7000, 8000, 9000),
        listOf(10000))

    check(part1(testInput) == 24000)

    val input = Day02::class.java.getResource("Day01.txt")
        ?.readText()
        ?.split("\r\n\r\n")
        ?.map { it.split("\r\n").map { it.toInt() } }


    check(input != null)

    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 45000)

    println("Part 2: ${part2(input)}")
}