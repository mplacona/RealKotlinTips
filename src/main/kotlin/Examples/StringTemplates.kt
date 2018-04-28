package Examples


/**
 * Name: String Templates in Kotlin
 *
 * Intro: Concatenating strings with a + is a waste of time when you can use string templates.
 * Outro: Strings in Kotlin may contain template expressions that are evaluated and whose results are concatenated into the string.
 * Publish: 2018-04-26
 */

fun simpleTemplate(name: String) = "Learn some cool Kotlin tips with $name"

fun expressionEvaluation(name: String) = "$name has ${name.length} characters"

fun complexFormat(number: Double) = "%.2f".format(number)

fun main(args: Array<String>) {
    val name = "RealKotlin"

    println(simpleTemplate(name))
    // Learn some cool Kotlin tips with RealKotlin

    println(expressionEvaluation(name))
    // RealKotlin has 10 characters

    println("pi = ${complexFormat(Math.PI)}")
    //pi = 3.14
}
