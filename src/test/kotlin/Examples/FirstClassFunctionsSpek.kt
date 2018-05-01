package Examples

import org.jetbrains.spek.api.*
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*

class FirstClassFunctionsSpek: Spek({
    context("Functions are first-class citizens in Kotlin"){
        describe("You can add a function to a variable in Kotlin") {
            val functions = mutableListOf(::add, ::subtract)
            it("should return a list of functions with one being called add") {
                val expected = "add"

                val actual = functions[0].name
                Assertions.assertEquals(expected, actual)
            }

            it("should return a list of functions with one being called subtract") {
                val expected = "subtract"

                val actual = functions[1].name
                Assertions.assertEquals(expected, actual)
            }
        }

        describe("test functionality of functions") {
            it("should return the sum of two numbers") {
                val expected = 42

                val actual = add(21, 21)
                Assertions.assertEquals(expected, actual)
            }

            it("should return the difference of two numbers") {
                val expected = 42

                val actual = subtract(56,14)
                Assertions.assertEquals(expected, actual)
            }

            it("should return the sum of two numbers with a function passed") {
                val expected = 42

                val actual = calculator(11,10, { a, b -> sum(a, b) })
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})