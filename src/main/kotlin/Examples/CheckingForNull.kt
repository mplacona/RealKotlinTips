package Examples


/**
 * Name: Checking for nulls in Kotlin
 *
 * Intro: Kotlin's type system is aimed to eliminate `NullPointerException's` from your code.
 * Outro: You can handle nulls explicitly or using the ?: Elvis Operator and get rid of those pesky NPEs.
 * Publish: 2018-05-24
 */


fun handleNullsExplicitly(name: String? = null): String? {
    return if (!name.isNullOrBlank()) name else "The one who shall remain nameless"
}

fun handleNullsWithElvisOperator(name: String? = null): String? {
    return name ?: return "The one who shall remain nameless"
}

fun main(args: Array<String>) {
    println(handleNullsExplicitly(""))
    // The one who shall remain nameless
    println(handleNullsExplicitly("Real Kotlin"))
    // Real Kotlin

    println(handleNullsWithElvisOperator())
    // The one who shall remain nameless
    println(handleNullsWithElvisOperator("Real Kotlin"))
    //Real Kotlin
}
