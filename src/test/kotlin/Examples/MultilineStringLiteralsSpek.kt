package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class MultilineStringLiteralsSpek : Spek({
    context("MultilineStringLiteralsSpek") {
        describe("Multiline string literals in java have always been clumsy") {
            it("should return indented string literal in multiple lines") {
                val expected ="""
        First Line
        Second Line
        Third Line
    """
                val actual = Examples.indentedStringLiteral()
                Assertions.assertEquals(expected, actual)
            }
            it("should return unindented string literal in multiple lines") {
                val expected ="""First Line
Second Line
Third Line"""
                val actual = Examples.unindentedStringLiteral()
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})