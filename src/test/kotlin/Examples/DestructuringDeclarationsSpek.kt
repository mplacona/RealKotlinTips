package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class DestructuringDeclarationsSpek : Spek({
    context("DestructuringDeclarationsSpek") {
        describe("A destructuring declaration creates multiple variables at once") {
            it("should return a destructured album map") {
                val albuns = mapOf(
                        "Heaven Upside Down" to "2017",
                        "The Pale Emperor" to "2015",
                        "Born Villain" to "2012"
                )
                val expected = "The album Heaven Upside Down was released in 2017 \n" +
                        "The album The Pale Emperor was released in 2015 \n" +
                        "The album Born Villain was released in 2012 \n"
                val actual = Examples.destructureAlbum(albuns)
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})