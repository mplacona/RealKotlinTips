package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class NamedArgumentsSpek : Spek({
    context("NamedArgumentsSpek") {
        describe("Using named arguments can make more expressive calls") {
            it("should allow for passing named arguments in any given order as long as the minimum is passed") {
                val realKotlin = Website(domain = "realkotlin", protocol = "https", tld = "com", subdomain = "www.")
                val expected = "https://www.realkotlin.com"
                val actual = Examples.getWebsite(realKotlin)
                Assertions.assertEquals(expected, actual)
            }

            it("should allow for passing named with missing non-mandatory values") {
                val kotlinAcademy = Website(domain = "kotlin-academy.herokuapp", protocol = "https", tld = "com")
                val expected = "https://kotlin-academy.herokuapp.com"
                val actual = Examples.getWebsite(kotlinAcademy)
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})