import Examples.capitalizeAll
import Examples.isNumeric
import Examples.isWeekend
import org.junit.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import java.util.*


@RunWith(JUnitPlatform::class)
class ExtensionFunctionSpek: Spek({
    context("Extension functions in Kotlin"){
        describe("A string capitaliser") {
            val string = "real kotlin"
            it("should return all first letters as capitals") {
                val capitalizeAll = string.capitalizeAll()
                assertEquals("Real Kotlin", capitalizeAll)
            }
        }
        describe("A weekend vs weekday analyser"){
            it("should return that the date passed is the weekend"){
                val date = GregorianCalendar(2018, Calendar.FEBRUARY, 17).time
                assertEquals(date.isWeekend(), true)
            }

            it("should return that the date passed is a weekday"){
                val date = GregorianCalendar(2018, Calendar.FEBRUARY, 16).time
                assertEquals(date.isWeekend(), false)
            }
        }

        describe("A string checker for numeric values"){
            it("should return that the value passed is a number"){
                val value = "42"
                assertEquals(value.isNumeric(), true)
            }

            it("should return that the value passed is not a number"){
                val value = "42 ponies"
                assertEquals(value.isNumeric(), false)
            }
        }
    }
})
