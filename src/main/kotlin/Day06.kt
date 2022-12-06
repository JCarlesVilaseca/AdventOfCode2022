import org.junit.Assert
import org.junit.Test

class Day06 {
    companion object {
        fun part1(input: String) =
            (0..input.length - 4)
                .first { input.substring(it, it + 4).asIterable().distinct().count() == 4 } + 4

        fun part2(input: String) =
            (0..input.length - 14)
                .first { input.substring(it, it + 14).asIterable().distinct().count() == 14 } + 14

        @JvmStatic
        fun main(args: Array<String>) {
            val input = object {}.javaClass.getResource("Day06.txt")
                ?.readText()

            check(input != null)

            println("Day06 Part 1: ${part1(input)}")
            println("Day06 Part 2: ${part2(input)}")
        }
    }
}

class TestDay06 {
    @Test
    fun test() {
        Assert.assertEquals(7, Day06.part1("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        Assert.assertEquals(5, Day06.part1("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        Assert.assertEquals(6, Day06.part1("nppdvjthqldpwncqszvftbrmjlhg"))
        Assert.assertEquals(10, Day06.part1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        Assert.assertEquals(11, Day06.part1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))

        Assert.assertEquals(19, Day06.part2("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        Assert.assertEquals(23, Day06.part2("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        Assert.assertEquals(23, Day06.part2("nppdvjthqldpwncqszvftbrmjlhg"))
        Assert.assertEquals(29, Day06.part2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        Assert.assertEquals(26, Day06.part2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }
}