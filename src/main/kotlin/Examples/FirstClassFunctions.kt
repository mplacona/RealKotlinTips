package Examples


/**
 * Name: Functions are first-class citizens in Kotlin
 *
 * Intro: Kotlin functions are first-class, which means they can be stored in variables and data structures, passed as arguments to and returned from other functions
 * Outro: Lambda expressions like the above are 'function literals' as they are not declared, but passed immediately as an expression. You can read more in [Lambda Expressions](http://kotlinlang.org/docs/reference/lambdas.html).
 * Publish: 2018-05-10
 */


fun add(a: Int, b: Int) = a + b

fun subtract(a: Int, b: Int) = a - b

fun calculator(a: Int, b: Int, sum: (Int, Int) -> Int): Int {
    return a + b + sum(a, b)
}

fun main(args: Array<String>) {
    val functions = mutableListOf(::add, ::subtract)

    println(functions[0])
    // fun add(kotlin.Int, kotlin.Int): kotlin.Int

    println(functions[0](12,30))
    // 12+30 = 42

    println(functions[1](57,15))
    // 57-15 = 42

    println(calculator(11, 10, { a, b -> sum(a, b) }))
    // 11+10+(11+10) = 42
}