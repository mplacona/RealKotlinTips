package Examples


/**
 * Name: Named Arguments in Kotlin
 *
 * Intro: Using named arguments you can make more expressive calls.
 * Outro: With parameter names you don’t have to care about argument order, and in many cases avoid overloading constructors for various parameter combinations.
 * Publish: 2018-06-21
 */

data class Website(val protocol:String, val subdomain: String? = null, val domain: String, val tld:String)

fun getWebsite(website: Website): String{
    return "${website.protocol}://${(website.subdomain ?: "")}${website.domain}.${website.tld}"
}

fun main(args: Array<String>) {
    val realKotlin = Website(domain = "realkotlin", protocol = "https", tld = "com", subdomain = "www.")
    println(getWebsite(realKotlin))
    // https://www.realkotlin.com

    val kotlinAcademy = Website(domain = "kotlin-academy.herokuapp", protocol = "https", tld = "com")
    println(getWebsite(kotlinAcademy))
    // https://kotlin-academy.herokuapp.com
}