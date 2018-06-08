package Examples


/**
 * Name: Destructuring Declarations in Kotlin
 *
 * Intro: A destructuring declaration creates multiple variables at once.
 * Outro: Destructuring declarations also conveniently work with for-loops and maps.
 * Publish: 2018-06-14
 */

data class Person(val name: String, val age: String)

fun destructureAlbum(albums: Map<String, String>): String {
    var destructuredMessage = ""
    for ((album, year) in albums) {
        destructuredMessage += "The album $album was released in $year \n"
    }
    return destructuredMessage
}

fun main(args: Array<String>) {
    val (name, age) = Person("Marcos Placona", "🤷‍")
    println("$name's age is $age")
    // Marcos Placona's age is 🤷‍

    val albums = mapOf(
        "Heaven Upside Down" to "2017",
        "The Pale Emperor" to "2015",
        "Born Villain" to "2012"
    )

    println(destructureAlbum(albums))
    //The album Heaven Upside Down was released in 2017
    //The album The Pale Emperor was released in 2015
    //The album Born Villain was released in 2012
}
