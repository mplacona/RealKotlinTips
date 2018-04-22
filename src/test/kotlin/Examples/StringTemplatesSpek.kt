package Examples

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class StringTemplatesSpek: Spek({
    context("String Templates in Kotlin"){
        describe("Concatenating string using string templates") {
            val name = "RealKotlin"
            it("should return a concatenated string") {
                val expected = "Learn some cool Kotlin tips with RealKotlin"

                val actual = simpleTemplate(name)
                Assertions.assertEquals(expected, actual)
            }

            it("should execute an expression inside the template") {
                val expected = "RealKotlin has 10 characters"

                val actual = expressionEvaluation(name)
                Assertions.assertEquals(expected, actual)
            }

            it("should format a given string") {
                val expected = "3.14"

                val actual = complexFormat(Math.PI)
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})