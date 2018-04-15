#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}

#end
#parse("File Header.java")

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class ${NAME}: Spek({
    context("${NAME}"){
        describe("${DESCRIPTION}") {
            it("${BEHAVIOUR}") {
                val expected = 
                val actual = Examples.${METHOD_NAME}()
                Assertions.assertEquals(expected, actual)
            }
        }
    }
})
