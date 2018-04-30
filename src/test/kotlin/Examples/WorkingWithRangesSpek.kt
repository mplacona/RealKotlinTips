package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class WorkingWithRangesSpek : Spek({
    context("Working with ranges in Kotlin") {
        describe("A simple range") {
            it("should return a range between 1 and 5") {
                val expected = "12345"
                val actual = createSimpleRange()
                Assertions.assertEquals(expected, actual)
            }
        }

        describe("A simple descending range") {
            it("should return a range between 5 and 1"){
                val expected = "54321"
                val actual = createDescendingRange()
                Assertions.assertEquals(expected,actual)
            }
        }

        describe("A simple range with a step"){
            it("should return a range between 2 and 10 with a step of 2"){
                val expected = "2 4 6 8 10"
                val actual = createRangeWithStep()
                Assertions.assertEquals(expected,actual)
            }
        }
    }
})