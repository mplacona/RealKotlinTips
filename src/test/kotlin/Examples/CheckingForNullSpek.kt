package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class CheckingForNullSpek : Spek({
    context("CheckingForNullSpek") {
        describe("Check for null implicitly") {
            it("should return a default message") {
                val expected = "The one who shall remain nameless"
                val actual = handleNullsExplicitly()
                Assertions.assertEquals(expected, actual)
            }
            it("should return a name") {
                val expected = "Real Kotlin"
                val actual = handleNullsExplicitly("Real Kotlin")
                Assertions.assertEquals(expected, actual)
            }
        }
        describe("Check for null using Elvis Operator") {
            it("should return a default message") {
                val expected = "The one who shall remain nameless"
                val actual = handleNullsWithElvisOperator()
                Assertions.assertEquals(expected, actual)
            }
            it("should return a name") {
                val expected = "Real Kotlin"
                val actual = handleNullsWithElvisOperator("Real Kotlin")
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})