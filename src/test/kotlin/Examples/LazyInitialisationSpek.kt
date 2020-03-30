package Examples

import org.jetbrains.spek.api.*
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*

internal class LazyInitialisationSpek : Spek({
    context("Lazy initialisation in Kotlin"){
        describe("Initialising properties lazily") {
            it("should return a map that is lazily defined") {
                val expected = HashMap<String, String>()
                expected["1st Request"] = "Hello RealKotlin"
                expected["2nd Request"] = "Hello RealKotlin"

                val actual = consumeLazyValue()
                Assertions.assertEquals(expected, actual)
            }

            it("should return a string that has been lazily initialised without thread safety") {
                val expected = "I am not synchronised"

                val actual = consumeLazyValueUnsynchronised()
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})