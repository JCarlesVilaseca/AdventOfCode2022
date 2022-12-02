import org.junit.Assert
import org.junit.Test
class TestDay02 {

    private val day02 = Day02(
        """
        A Y
        B X
        C Z
             """.trimIndent().lines()
    )
    @Test
    fun part1() {
        Assert.assertEquals("15", day02.part1())
        Assert.assertEquals("12", day02.part2())
    }
}