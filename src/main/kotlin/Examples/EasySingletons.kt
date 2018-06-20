package Examples


/**
 * Name: Easy Singletons in Kotlin
 *
 * Intro: Singleton pattern involves a single class which is responsible to create an object while making sure that only one single instance gets created.
 * Outro: Kotlin objects are singletons out-of-the-box which means you don't need any logic inside it to make sure only one instance of it is created.
 * Publish: 2018-06-28
 */

class ClassSingleton {
    var info = "Initial info class"

    companion object {
        private var INSTANCE: ClassSingleton? = null

        val instance: ClassSingleton
            get() {
                if (INSTANCE == null) {
                    INSTANCE = ClassSingleton()
                }

                return INSTANCE!!
            }
    }
}

object ObjectSingleton {
    var info = "Initial info object"
}

fun main(args: Array<String>) {
    val classSingleton1 = ClassSingleton.instance
    val classSingleton2 = ClassSingleton.instance
    classSingleton2.info = "new class info"

    println(classSingleton1.info)
    //New class info
    println(classSingleton2.info)
    //New class info

    val objectSingleton1 = ObjectSingleton
    val objectSingleton2 = ObjectSingleton
    objectSingleton2.info = "new object info"

    println(objectSingleton1.info)
    //New object info
    println(objectSingleton2.info)
    //New object info
}
