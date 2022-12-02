import org.junit.Assert
import org.junit.Test
class TestDay01 {

    private val day01 = Day01(
        """
             1000
             2000
             3000
            
             4000
            
             5000
             6000
            
             7000
             8000
             9000
            
             10000
             """.trimIndent().replace("\n", "\r\n")
    )
    @Test
    fun part1() {
        Assert.assertEquals("24000", day01.part1())
        Assert.assertEquals("45000", day01.part2())
    }
}