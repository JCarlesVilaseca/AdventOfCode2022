
import org.junit.Assert
import org.junit.Test

open class Entry {

}

class File(size: Int): Entry() {}

class Folder(parent: Folder?): Entry() {
    var entries: Map<String, Entry> = emptyMap()
}

class AdventFileSystem {
    var root = Folder(null)
    var currentFolder: Folder = root
}

class Day07 {
    companion object {
        fun part1(fs: AdventFileSystem, commands: List<String>) =
            0

        fun part2(fs: AdventFileSystem, commands: List<String>) =
            0

        @JvmStatic
        fun main(args: Array<String>) {
            val input = object {}.javaClass.getResource("Day07.txt")
                ?.readText()
                ?.lines()

            check(input != null)

            println("Day07 Part 1: ${part1(AdventFileSystem(), input)}")
            println("Day07 Part 2: ${part2(AdventFileSystem(), input)}")
        }
    }
}

class TestDay07 {
    @Test
    fun test() {
        var input = """
            ${'$'} cd /
            ${'$'} ls
            dir a
            14848514 b.txt
            8504156 c.dat
            dir d
            ${'$'} cd a
            ${'$'} ls
            dir e
            29116 f
            2557 g
            62596 h.lst
            ${'$'} cd e
            ${'$'} ls
            584 i
            ${'$'} cd ..
            ${'$'} cd ..
            ${'$'} cd d
            ${'$'} ls
            4060174 j
            8033020 d.log
            5626152 d.ext
            7214296 k
        """.trimIndent().lines()

        Assert.assertEquals(95437, Day07.part1(AdventFileSystem(), input))

        //Assert.assertEquals(19, Day07.part2(AdventFileSystem(), input))
    }
}