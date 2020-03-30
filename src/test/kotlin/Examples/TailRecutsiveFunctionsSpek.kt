package Examples

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions
import java.math.BigInteger

class TailRecutsiveFunctionsSpek : Spek({
    context("Tail recursive functions in Kotlin") {
        describe("Functions should be optimized using loops when marked as tailrec") {
            it("should return the correct factorial value") {
                val expected = BigInteger("720")
                val actual = Examples.factorial(BigInteger("6"))
                Assertions.assertEquals(expected, actual)
            }
            it("should return the correct fibonacci value") {
                val expected = BigInteger("8")
                val actual = Examples.fibonacci(6, BigInteger.ZERO, BigInteger.ONE)
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})