import org.junit.Assert
import org.junit.Test
import java.security.InvalidParameterException

class Day02 {
    companion object {
        fun part1(input: List<Pair<Int, Int>>) =
            input
                .sumOf { ((it.second + 4 - it.first) % 3) * 3 + it.second + 1 }

        fun part2(input: List<Pair<Int, Int>>) =
            input
                .sumOf { ((it.second + 2 + it.first) % 3) + it.second * 3 + 1 }

        @JvmStatic
        fun main(args: Array<String>) {
            val input = object {}.javaClass.getResource("Day02.txt")
                ?.readText()
                ?.lines()
                ?.map {
                    it.split(" ")
                        .map { it.toValue() }
                        .let { it[0] to it[1] }
                }

            check(input != null)

            println("Day02 Part 1: ${part1(input)}")
            println("Day02 Part 2: ${part2(input)}")
        }

        private fun String.toValue(): Int {
            when (this) {
                "X", "A" -> return 0
                "Y", "B" -> return 1
                "Z", "C" -> return 2
            }
            throw InvalidParameterException()
        }

    }
}

class TestDay02 {
    @Test
    fun test() {
        val input = listOf(0 to 1, 1 to 0, 2 to 2)

        Assert.assertEquals(15, Day02.part1(input))
        Assert.assertEquals(12, Day02.part2(input))
    }
}