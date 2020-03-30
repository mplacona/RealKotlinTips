package Examples

/**
 * Name: Lazy initialisation in Kotlin
 *
 * Intro: Just like [Late Initialisation](/tutorials/2018-05-01-late-initialisation-in-kotlin) `lazy` lets you initialise a property only when you need it, but it also remembers its value for future calls.
 * Outro: `lazy` properties are also thread safe as they run in `synchronized` mode. If using `lazy` on the main thread and nowhere else, you may avoid the `synchronized` overhead by removing its thread safety. This mode should be used only when high performance is crucial and the `lazy` instance is guaranteed never to be initialised from more than one thread.
 * Publish: 2018-05-03
 */

private val lazyValue: String by lazy {
    println("First hit")
    "Hello RealKotlin"
}

private val lazyValueWithoutThreadSafety: String by lazy(LazyThreadSafetyMode.NONE){
    "I am not synchronised"
}

fun consumeLazyValue(): Map<String, String> {
    return mapOf(
            "1st Request" to lazyValue,
            "2nd Request" to lazyValue
    )
}

fun consumeLazyValueUnsynchronised(): String {
    return lazyValueWithoutThreadSafety
}

fun main(args: Array<String>) {
    println(consumeLazyValue())
    // First hit
    // {1st Request=Hello RealKotlin, 2nd Request=Hello RealKotlin}

    for (i in 1..3) {
        println(consumeLazyValueUnsynchronised())
    }
    //I am not synchronised
    //I am not synchronised
    //I am not synchronised

}
