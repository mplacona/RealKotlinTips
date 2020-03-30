package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class GroupInitialisationSpek : Spek({
    context("GroupInitialisationSpek") {
        describe("Group initialisation in Kotlin") {
            it("should create the same type of object regardless of how the object is initialised") {
                val expected = Examples.User("Real Kotlin", 1, "https://www.reallkotlin.com")
                val actual = Examples.User("Real Kotlin").apply {
                    age = 1
                    website = "https://www.reallkotlin.com"
                }
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})