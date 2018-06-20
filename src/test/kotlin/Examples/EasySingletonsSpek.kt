package Examples


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class EasySingletonsSpek : Spek({
    context("Singleton pattern involves a single class which is responsible to create an object while making sure that only one single instance gets created.") {
        describe("A class can be instantiated multiple times and only it's last value will remain") {
            it("should return the same instance of a class previously created") {
                val expected = "new class info"
                val classSingleton1 = Examples.ClassSingleton.instance
                val classSingleton2 = Examples.ClassSingleton.instance
                classSingleton2.info = expected
                val actual = classSingleton1.info
                Assertions.assertEquals(expected, actual)
            }
            it("should return the saem instance of an object previously created") {
                val expected = "new class info"
                val objectSingleton1 = Examples.ObjectSingleton
                val objectSingleton2 = Examples.ObjectSingleton
                objectSingleton2.info = expected
                val actual = objectSingleton1.info
                Assertions.assertEquals(expected, actual)
            }
        }

    }
})