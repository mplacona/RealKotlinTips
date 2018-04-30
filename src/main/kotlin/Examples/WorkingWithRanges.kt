package Examples


/**
 * Name: Working With Ranges
 *
 * Intro: Kotlin provides a simple and intuitive way to create ranges.
 * Outro: With Kotlin you can easily create ranges including ranges in reverse order as well as those with defined steps.
 * Publish:
 */

// Range from 1 to 5
fun createSimpleRange(): String {
    var str = ""
    for (i in 1..5) {
        str += i
    }
    return str
}

// Range from 5 to 1
fun createDescendingRange(): String {
    var str = ""
    for (i in 5 downTo 1) {
        str += i
    }
    return str
}

// Creates a range from 2 to 10 in steps of 2
fun createRangeWithStep(): String{
    var str = ""
    for (i in 2..10 step 2) {
        str = "${str.trim()} $i"
    }
    return str
}

fun main(args: Array<String>) {
    println(createSimpleRange())
    // 12345

    println(createDescendingRange())
    // 54321

    println(createRangeWithStep())
    // 2 4 6 8 10
}
