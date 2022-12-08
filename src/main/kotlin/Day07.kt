
import org.junit.Assert
import org.junit.Test

interface Entry {
    fun calculateSize(): Int
}

class File(private val size: Int): Entry {
    override fun calculateSize(): Int {
        return size
    }
}

class Folder(public val parent: Folder?): Entry {
    var entries: MutableMap<String, Entry> = mutableMapOf()

    override fun calculateSize(): Int {
        return entries.values.sumOf { it.calculateSize() }
    }
}




class AdventFileSystem {
    public var root = Folder(null)
    private var currentFolder: Folder = root

    fun cd(dir: String) {
        currentFolder = when(dir) {
            "/"  -> root
            ".." -> {
                check(currentFolder.parent != null)
                currentFolder.parent!!
            }

            else -> {
                check(currentFolder.entries.containsKey(dir) && currentFolder.entries[dir] is Folder)
                currentFolder.entries[dir] as Folder
            }
        }
    }

    fun addFolder(name: String) {
        currentFolder.entries[name] = Folder(currentFolder)
    }

    fun addFile(name: String, size: Int) {
        currentFolder.entries[name] = File(size)
    }

    fun asSequence(): Sequence<Folder> {
        return root.asSequence()
    }

}

fun Folder.asSequence(): Sequence<Folder> = sequence {
    yield(this@asSequence)
    entries.values.filterIsInstance<Folder>().forEach { yieldAll(it.asSequence()) }
}

class Day07 {
    companion object {

        fun part1(fs: AdventFileSystem, commands: List<String>): Int {
            runCommands(fs, commands)

            return fs.asSequence().map { it.calculateSize() }.filter { it < 100000 }.sum()
        }

        fun part2(fs: AdventFileSystem, commands: List<String>): Int {
            runCommands(fs, commands)
            val free = 70000000 - fs.root.calculateSize()

            return fs.asSequence().map { it.calculateSize() }.filter { it + free > 30000000 }.sorted().first()
        }

        private fun runCommands(fs: AdventFileSystem, commands: List<String>) {
            commands.forEach { cmd ->

                when (cmd[0]) {
                    '$' -> {
                        val parts = cmd.drop(2).split(' ')
                        when (parts[0]) {
                            "ls" -> {

                            }

                            "cd" -> fs.cd(parts[1])
                        }
                    }

                    else -> {
                        val parts = cmd.split(' ')
                        when (parts[0]) {
                            "dir" -> fs.addFolder(parts[1])
                            else -> fs.addFile(parts[1], parts[0].toInt())
                        }
                    }
                }
            }
        }

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

        Assert.assertEquals(24933642, Day07.part2(AdventFileSystem(), input))
    }
}