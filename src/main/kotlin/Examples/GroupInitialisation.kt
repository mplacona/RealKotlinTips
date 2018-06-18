package Examples


/**
 * Name: Group Initialisation in Kotlin
 *
 * Intro: Group object initialisation in Kotlin promote cleaner and easier to read code.
 * Outro: A caveat for using this type of initialisation is that all properties will end up being `vars` and therefore mutable which can cause undesired behaviour.
 * Publish: 2018-06-19
 */

data class User(val name: String, var age: Int = 0, var website: String = "")

fun main(args: Array<String>) {
    val user1 = User("Marcos Placona")
    user1.age = 34
    user1.website = "https://www.placona.co.uk"
    println(user1)
    // User(name=Marcos Placona, age=34, website=https://www.placona.co.uk)


    println(User("RealKotlin").apply {
        age = 1
        website = "https://www.realkotlin.com"
    })
    //User(name=RealKotlin, age=1, website=https://www.realkotlin.com)
}
