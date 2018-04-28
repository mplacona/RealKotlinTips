package Examples

import org.jetbrains.spek.api.*
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*

internal class LateInitialisationSpek : Spek({
    context("Late initialisation in Kotlin"){
        describe("Initialising properties lazily") {
            it("should return a message with a value that is set lazily in the method") {
                val expected = "We didn't even need to say RealKotlin until now"

                val actual = getMessage()
                Assertions.assertEquals(expected, actual)
            }

            it("should return a different value for the variable since lateinit is not immutable") {
                val expected = "42"

                val actual = getNewMessage()
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})