import org.junit.Assert
import org.junit.Test

class Day01 {
    companion object {
        fun part1(input: Iterable<Iterable<Int>>) =
            input
                .map { it.sum() }
                .sortedDescending()
                .take(1)
                .sum()

        fun part2(input: Iterable<Iterable<Int>>) =
            input
                .map { it.sum() }
                .sortedDescending()
                .take(3)
                .sum()

        @JvmStatic
        fun main(args: Array<String>) {
            val input = object {}.javaClass.getResource("Day01.txt")
                ?.readText()
                ?.split("\r\n\r\n")
                ?.map { it.split("\r\n").map { it.toInt() } }

            check(input != null)

            println("Day01 Part 1: ${part1(input)}")
            println("Day01 Part 2: ${part2(input)}")
        }
    }
}

class TestDay01 {
    @Test
    fun test() {
        val input = listOf(
            listOf(1000, 2000, 3000),
            listOf(4000),
            listOf(5000, 6000),
            listOf(7000, 8000, 9000),
            listOf(10000)
        )

        Assert.assertEquals(24000, Day01.part1(input))
        Assert.assertEquals(45000, Day01.part2(input))
    }
}