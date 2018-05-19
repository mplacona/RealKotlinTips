package Examples

import kotlin.properties.Delegates


/**
 * Name: Vetoable properties in Kotlin
 *
 * Intro: Vetoable are delegate properties that allow you to update a property value if a certain condition is matched.
 * Outro: The value will only change once we hit a condition set by the property.
 * Publish: 2018-05-22
 */

private var vetoableValue: String by Delegates.vetoable("Real Kotlin") {
    // Will only update if the proposed value starts with an R
    _, _, new -> new.startsWith("R")
}

fun failVetoableCondition(): String {
    vetoableValue = "Won't update"
    return vetoableValue
}

fun passVetoableCondition(): String {
    vetoableValue = "Royal Wedding"
    return vetoableValue
}

fun main(args: Array<String>) {
    println(vetoableValue)
    // Real kotlin

    println(failVetoableCondition())
    // Real Kotlin

    println(passVetoableCondition())
    // Royal Wedding
}
