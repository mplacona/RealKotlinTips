package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class FlatteningSpek : Spek({
    context("With the flatten method in Kotlin, you can turn list of lists and arrays of arrays into a single list of all elements") {
        describe("Flattening Lists and Arrays") {
            it("should return a flattened list") {
                val expected = listOf(1, 2, 3, "one", "two", "three")
                val actual = Examples.simpleFlattenedList(listOf(listOf(1, 2, 3), listOf("one", "two", "three")))
                Assertions.assertEquals(expected, actual)
            }
            it("should turn a complex array into a flattened list") {
                val expected = listOf(1, 2, 3, 4, 5)
                val actual = Examples.flattenedArray(arrayOf(arrayOf(1), arrayOf(2, 3), arrayOf(4, 5)))
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})