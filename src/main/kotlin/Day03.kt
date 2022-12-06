
import org.junit.Assert
import org.junit.Test

class Day03 {
    companion object {
        fun part1(input: List<String>) =
            input
                .map { it.substring(0, it.length / 2) to it.substring(it.length / 2)}
                .map { it.first.first { char -> it.second.contains(char) }}
                .sumOf { priority(it) }
        fun part2(input: List<String>) =
            input
                .withIndex()
                .groupBy { it.index / 3 }
                .map { it.value.first().value.first { char -> it.value.drop(1).all { line -> line.value.contains(char)} } }
                .sumOf { priority(it) }

        private fun priority(chr: Char) =
            if (chr.isLowerCase()) chr.code - 'a'.code + 1 else chr.code - 'A'.code + 27
        @JvmStatic
        fun main(args: Array<String>) {
            val input = object {}.javaClass.getResource("Day03.txt")
                ?.readText()
                ?.lines()

            check(input != null)

            println("Day03 Part 1: ${part1(input)}")
            println("Day03 Part 2: ${part2(input)}")
        }
    }
}

class TestDay03 {
    @Test
    fun test() {
        val input = listOf(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw"
        )

        Assert.assertEquals(157, Day03.part1(input))
        Assert.assertEquals( 70, Day03.part2(input))
    }
}