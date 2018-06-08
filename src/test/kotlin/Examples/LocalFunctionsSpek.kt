package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class LocalFunctionsSpek : Spek({
    context("LocalFunctionsSpek") {
        describe("Kotlin supports local functions, i.e. it allows you to put a function inside a function") {
            it("should accumulate a given number") {
                val expected = 42
                val actual = Examples.accumulate(32)
                Assertions.assertEquals(expected, actual)
            }

            it("should give a correct BMI calculation") {
                val expected = 25.0
                val actual = Examples.calculateBMI(100.0, 200.0)
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})