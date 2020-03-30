package Examples


/**
 * Name: Collection Filtering in Kotlin
 *
 * Intro: Most often than not, when dealing with collections there's a need for filtering them before displaying.
 * Outro: Using the built-in `filter` method you can filter values by any of the properties returned with the object.
 * Publish:2018-07-10
 */

val users = listOf(User("Marcos Placona"), User("Arwa Hogan", active = false), User("Ellie Mack"), User("Meredith Mccarthy", active = false))

fun getActiveUsers() = users.filter { it.active }
fun getInactiveUsers() = users.filter { !it.active }
fun getNamesStartingWithM() = users.filter { it.name.startsWith("M") }

fun main(args: Array<String>) {
    println(getActiveUsers())
    // [User(name=Marcos Placona, age=0, website=, active=true), User(name=Ellie Mack, age=0, website=, active=true)]
    println(getInactiveUsers())
    // [User(name=Arwa Hogan, age=0, website=, active=false), User(name=Theon Mccarthy, age=0, website=, active=false)]
    println(getNamesStartingWithM())
    // [User(name=Marcos Placona, age=0, website=, active=true), User(name=Meredith Mccarthy, age=0, website=, active=false)]
}
