package Examples

/**
 * Name: Late initialisation in Kotlin
 *
 * Intro: Non-null type properties must be initialised in the constructor but that's not always very convenient. `lateinit` properties change that.
 * Outro: Whenever you need a mutable property or one that is set outside of your class, `lateinit` may be just what you need.
 * Publish: 2018-05-01
 */

private lateinit var name: String

fun getMessage(): String {
    name = "RealKotlin"
    val message = "We didn't even need to say $name until now"
    // lateinit properties are always mutable. Be careful!
    name = "42"
    return message
}

fun getNewMessage(): String = name

fun main(args: Array<String>) {
    println(getMessage())
    // We didn't even need to say RealKotlin until now

    println(getNewMessage())
    // 42
}