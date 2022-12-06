
import org.junit.Assert
import org.junit.Test
import java.lang.Integer.max
import java.lang.Integer.min

class Day04 {
    companion object {
        fun part1(input: List<Pair<Pair<Int,Int>, Pair<Int,Int>>>) =
            input.count {
                it.first.first >= it.second.first && it.first.second <= it.second.second
                        || it.second.first >= it.first.first && it.second.second <= it.first.second
            }
        fun part2(input: List<Pair<Pair<Int,Int>, Pair<Int,Int>>>) =
            input.count {
                max(it.first.first, it.second.first) <= min(it.first.second, it.second.second)
            }

        @JvmStatic
        fun main(args: Array<String>) {
            val input = object {}.javaClass.getResource("Day04.txt")
                ?.readText()
                ?.lines()
                ?.map {
                    it.split(',')
                        .let { it[0].split('-').let { it[0].toInt() to it[1].toInt()} to it[1].split('-').let { it[0].toInt() to it[1].toInt()} } }

            check(input != null)

            println("Day04 Part 1: ${part1(input)}")
            println("Day04 Part 2: ${part2(input)}")
        }
    }
}

class TestDay04 {
    @Test
    fun test() {
        val input = listOf(
            (2 to 4) to (6 to 8),
            (2 to 3) to (4 to 5),
            (5 to 7) to (7 to 9),
            (2 to 8) to (3 to 7),
            (6 to 6) to (4 to 6),
            (2 to 6) to (4 to 8)
        )

        Assert.assertEquals(2, Day04.part1(input))
        Assert.assertEquals( 4, Day04.part2(input))
    }
}