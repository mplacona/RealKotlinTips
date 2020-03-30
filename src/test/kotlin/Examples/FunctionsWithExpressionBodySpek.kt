package Examples

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class FunctionsWithExpressionBodySpek : Spek({
    context("Functions With Expression BodySpek") {
        describe("Definining a one line function") {
            it("should double a given number") {
                val expected = 42
                val actual = double(21)
                Assertions.assertEquals(expected, actual)
            }

            it("should sum two given numbers") {
                val expected = 42
                val actual = sum(30, 12)
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})
