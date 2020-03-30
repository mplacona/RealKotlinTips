package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class VetoablePropertiesSpek : Spek({
    context("Vetoable Properties in Kotlin") {
        describe("Vetoable properties only update when a given condition is matched") {
            it("should fail when a vetoable condition does not match") {
                val expected = "Real Kotlin"
                val actual = Examples.failVetoableCondition()
                Assertions.assertEquals(expected, actual)
            }
            it("should succeed when a vetoable condition matches") {
                val expected = "Royal Wedding"
                val actual = Examples.passVetoableCondition()
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})