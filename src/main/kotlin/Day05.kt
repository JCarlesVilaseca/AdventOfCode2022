import org.junit.Assert
import org.junit.Test

class Day05 {
    companion object {
        fun part1(input: Pair<List<ArrayDeque<Char>>, List<Triple<Int, Int, Int>>>): String {
            input.second.forEach { action ->
                (0 until action.first).forEach {
                    val item = input.first[action.second - 1].removeLast()
                    input.first[action.third - 1].addLast(item)
                }
            }

            return input.first.filter { !it.isEmpty() }.map { it.last() }.joinToString("")
        }

        fun part2(input: Pair<List<ArrayDeque<Char>>, List<Triple<Int, Int, Int>>>) : String {
            input.second.forEach { action ->
                (0 until action.first).sortedDescending().forEach {
                    val source =input.first[action.second - 1]
                    val item = source.removeAt(source.count() - it - 1)
                    input.first[action.third - 1].addLast(item)
                }
            }

            return input.first.filter { !it.isEmpty() }.map { it.last() }.joinToString("")
        }

        fun parse(input: List<String>): Pair<List<ArrayDeque<Char>>, List<Triple<Int, Int, Int>>> {
            var headLength = input.withIndex().find { it.value.isEmpty() }?.index

            check(headLength != null)
            headLength -= 1

            val width = (input[0].length+1) / 4

            val stack =
                (0 until width)
                    .map { col ->
                        ArrayDeque(input
                            .asSequence()
                            .take(headLength)
                            .withIndex()
                            .sortedByDescending { it.index }
                            .filter { row -> row.value[col * 4 + 1] != ' '}
                            .map { row -> row.value[col * 4 + 1]}
                            .toList())
                    }
            val reg = """move ([\d]*) from ([\d]*) to ([\d]*)""".toRegex()

            val actions = input
                .drop(headLength + 2)
                .map {
                        val result = reg.matchEntire(it)

                        check(result != null && result.groups.count() == 4)

                        result.groups.let { group -> Triple(group[1]?.value?.toInt()!!, group[2]?.value?.toInt()!!, group[3]?.value?.toInt()!!) }
                    }

            return Pair(stack, actions )
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val input = object {}.javaClass.getResource("Day05.txt")
                ?.readText()
                ?.lines()

            check(input != null)

            println("Day05 Part 1: ${part1(parse(input))}")
            println("Day05 Part 2: ${part2(parse(input))}")
        }
    }
}

class TestDay05 {
    @Test
    fun test() {
        val input =
                """|    [D]    
                   |[N] [C]    
                   |[Z] [M] [P]
                   | 1   2   3 
                   |
                   |move 1 from 2 to 1
                   |move 3 from 1 to 3
                   |move 2 from 2 to 1
                   |move 1 from 1 to 2""".trimMargin().lines()

        Assert.assertEquals("CMZ", Day05.part1(Day05.parse(input)))
        Assert.assertEquals( "MCD", Day05.part2(Day05.parse(input)))
    }
}