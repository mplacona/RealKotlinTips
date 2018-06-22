package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue

class CallingMultipleMethods : Spek({
    context("CallingMultipleMethods") {
        describe("Kotlin lets you call multiple methods on the same object") {
            lateinit var stringParser: StringParser
            lateinit var htmlString:String
            beforeEachTest {
                val htmlString = """
                    <html>
                        <header><title>This is a title</title></header>
                        <body>
                            Hello world!!!
                        </body>
                    </html>
                """.trimIndent()
                stringParser = StringParser(htmlString)
            }

            it("should return a new instance os StringParser") {
                assertTrue(stringParser is StringParser)
            }

            it("should clear a string when there's HTML characters on it") {
                val expected = "This is a title\n" +
                        "    \n" +
                        "        Hello world!!!"
                val actual = stringParser.removeHTMLTags()
                Assertions.assertEquals(expected, actual.trim())
            }

            it("should clear a string when there's special characters") {
                val expected = "html    headertitleThis is a titletitleheader    body        Hello world    bodyhtml"
                val actual = stringParser.removeSpecialCharacters()
                Assertions.assertEquals(expected, actual.trim())
            }

            it("should remove leading and trailling spaces from string") {
                val spacedString = "    some text     "
                val expected = spacedString.trim()
                stringParser = StringParser(spacedString)
                val actual = stringParser.removeLeadingAndTrailingSpaces()
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})