package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class CollectionFilteringSpek : Spek({
    context("CollectionFilteringSpek") {
        val users = listOf(User("Marcos Placona"), User("Arwa Hogan", active = false), User("Ellie Mack"), User("Meredith Mccarthy", active = false))

        describe("When dealing with collections there'd often a need for filtering values before displaying") {
            it("should only return active users") {
                val expected = listOf(User("Marcos Placona"), User("Ellie Mack"))
                val actual = Examples.getActiveUsers()
                Assertions.assertEquals(expected, actual)
            }

            it("should only return inactive users") {
                val expected = listOf(User("Arwa Hogan", active = false), User("Meredith Mccarthy", active = false))
                val actual = Examples.getInactiveUsers()
                Assertions.assertEquals(expected, actual)
            }

            it("should only return users where name start with an `M`") {
                val expected = listOf(User("Marcos Placona"), User("Meredith Mccarthy", active = false))
                val actual = Examples.getNamesStartingWithM()
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})