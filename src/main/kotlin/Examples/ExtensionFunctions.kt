package Examples

/**
 * Name: Extension functions in Kotlin.
 *
 * Intro: In most programming languages you have to derive a new class. In Kotlin you can extend a class with new functionality
 * Outro: An extension function is a member function of a class that is defined outside the class and valiud throughout your project.
 */

import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream

// Check if a given date falls on a weekend and return true or false
fun Date.isWeekend() = day == 6 || day == 7

// Check whether a given string is numeric
fun String.isNumeric(): Boolean{
    return this.matches("\\d+".toRegex())
}

// Capitalise the first character on every word in a given string
fun String.capitalizeAll(): String {
    return Stream.of(*this.trim { it <= ' ' }.split("\\s".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
            .filter { word -> word.isNotEmpty() }
            .map { word -> word.substring(0, 1).toUpperCase() + word.substring(1) }
            .collect(Collectors.joining(" "))
}

fun main(args: Array<String>) {
    println(if (Date().isWeekend()) "It's the weekend 🎉" else "It's not the weekend 🙈")

    println("real kotlin".capitalizeAll())

    val value = "42"
    println(if(value.isNumeric()) "$value is a number" else "$value is not a number")
}