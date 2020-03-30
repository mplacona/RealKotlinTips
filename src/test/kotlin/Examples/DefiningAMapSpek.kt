package Examples

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class DefiningAMapSpek: Spek({
    context("Defining a map in Kotlin"){
        describe("Defining a map without types or the use of put") {
            it("should return a map that has the same structure as one manually defined") {
                val expected = HashMap<String, String>()
                expected["keyA"] = "valueA"
                expected["keyB"] = "valueB"
                expected["keyC"] = "valueC"

                val actual = createImplicitMap()
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})