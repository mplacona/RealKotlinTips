package Examples


/**
 * Name: Calling Multiple Methods in Kotlin
 *
 * Intro: Kotlin lets you call multiple methods on the same object.
 * Outro: Using `with` you can chain all the method calls in the object instance and have it return the result of the last expression.
 * Publish: 2018-07-05
 */

class StringParser(var string: String) {
    fun removeHTMLTags(): String {
        string = Regex("<[^>]*>").replace(string, "")
        return string
    }

    fun removeSpecialCharacters(): String {
        string = Regex("[^A-Za-z0-9 ]").replace(string, "")
        return string
    }

    fun removeLeadingAndTrailingSpaces(): String {
        return string.trim()
    }
}

fun main(args: Array<String>) {
    val htmlString = """
        <html>
            <header><title>This is a title</title></header>
            <body>
                Hello world!!!
            </body>
        </html>
    """.trimIndent()
    val stringParser = StringParser(htmlString)

    val response = with(stringParser) {
        removeHTMLTags()
        removeSpecialCharacters()
        removeLeadingAndTrailingSpaces()
    }

    println(response)
    // This is a title            Hello world
}
