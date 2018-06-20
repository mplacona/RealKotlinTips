package Examples


/**
 * Name: Multiline String Literals in Kotlin
 *
 * Intro: Multiline String Literals in Java have always been clumsy and full of + operators for line-breaks.
 * Outro: In Kotlin you just have to define multiline strings in triple quotes and even get rid of indents.
 * Publish: 2018-06-26
 */

fun indentedStringLiteral() =
    """
        First Line
        Second Line
        Third Line
    """

fun unindentedStringLiteral() =
    """
        First Line
        Second Line
        Third Line
    """.trimIndent()


fun main(args: Array<String>) {
    println(indentedStringLiteral())
    //         First line
    //        Second Line
    println(unindentedStringLiteral())
    //First line
    //Second Line
    //Third line
}
