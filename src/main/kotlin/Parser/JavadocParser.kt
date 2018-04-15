import java.io.BufferedWriter
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.text.Normalizer
import java.util.*
import java.util.regex.Pattern


data class FileDescriptor(val name: String?, val fileName: String, val intro: String?, val outro: String?, val publish: String?, val code: String?) {

}

fun main(args: Array<String>) {

//    val engine = ScriptEngineManager().getEngineByExtension("kts")
//    val myCode = """
//        import java.util.*
//        val duplicates = arrayOf("a", "b", "c", "a", "c")
//        val uniques = Arrays.asList(*duplicates).toSet()
//        print(uniques)
//    """
//    println(myCode)
//    engine.eval(myCode)

    Files.walk(Paths.get("/Users/mplacona/Projects/Kotlin/Tricks/src/main/kotlin/Examples/")).use({ paths ->
        paths
                .filter({ it.toFile().isFile })
                .filter({ it.toFile().extension == "kt" })
                .forEach({
                    val fileContents = File(it.toUri()).readText()
                    val nameRegex = "Name:(.*)".toRegex()
                    val name = tokenize(fileContents, nameRegex)
                    val fileName = toSlug(name)

                    val introRegex = "Intro:(.*)".toRegex()
                    val intro = tokenize(fileContents, introRegex)

                    val outroRegex = "Outro:(.*)".toRegex()
                    val outro = tokenize(fileContents, outroRegex)

                    val publishRegex = "Publish:(.*)".toRegex()
                    val publish = tokenize(fileContents, publishRegex)

                    val codeRegex = "\\*/(.*)".toRegex(RegexOption.DOT_MATCHES_ALL)
                    val code = tokenize(fileContents, codeRegex)

                    createFile(FileDescriptor(name, fileName, intro, outro, publish, code))
                })
    })
}

fun createFile(fileDescriptor: FileDescriptor) {
    File("""/Users/mplacona/Desktop/websites/realkotlin.com/_tutorials/${fileDescriptor.publish}-${fileDescriptor.fileName}.md""").bufferedWriter().use { out ->
        out.writeLn("---")
        out.writeLn("title: \"${fileDescriptor.name}\"")
        out.writeLn("excerpt: \"${fileDescriptor.intro}\"")
        out.writeLn("date: \"${fileDescriptor.publish}\"")
        out.writeLn("author: Marcos Placona")
        out.writeLn("---")
        out.newLine()
        out.writeLn("```kotlin")
        out.writeLn("${fileDescriptor.code}")
        out.writeLn("```")
        out.newLine()
        out.writeLn("${fileDescriptor.outro}")
    }
}

fun tokenize(fileContents: String, pattern: Regex, index: Int = 1): String?{
    val matchResult = pattern.find(fileContents)
    return matchResult?.groupValues?.get(index)?.trim()
}

fun toSlug(input: String?): String {
    val nonLatin = Pattern.compile("[^\\w-]")
    val whiteSpace = Pattern.compile("[\\s]")
    val noWhiteSpace = whiteSpace.matcher(input).replaceAll("-")
    val normalized = Normalizer.normalize(noWhiteSpace, Normalizer.Form.NFD)
    val slug = nonLatin.matcher(normalized).replaceAll("")
    return slug.toLowerCase(Locale.ENGLISH)
}

// Convert any form of new lines to system agnostic new line
fun BufferedWriter.writeLn(line: String) {
    this.write(line)
    this.newLine()
}