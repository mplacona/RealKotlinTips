package Examples

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class RemoveArrayDuplicatesSpek: Spek({
    context("Remove array duplicates in Kotlin."){
        describe("An Array duplicate remover function") {
            val duplicates = arrayOf("a", "b", "c", "a", "c")
            it("should return a set of distinct items") {
                val expected = duplicates.distinct().toTypedArray()
                val distinctItems = removeArrayDuplicates(duplicates)
                Assertions.assertArrayEquals(expected, distinctItems)
            }
        }
    }
})