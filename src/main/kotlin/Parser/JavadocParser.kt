import java.io.BufferedWriter
import java.io.File
import java.io.FileInputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.text.Normalizer
import java.util.*
import java.util.regex.Pattern

data class FileDescriptor(val name: String?, val fileName: String, val intro: String?, val outro: String?, val publish: String?, val author: String?, val code: String?)

private fun readLocalProperties(): Properties{
    val properties = Properties()
    val propertiesFile = System.getProperty("user.dir") + "/local.properties"

    val inputStream = FileInputStream(propertiesFile)
    properties.load(inputStream)

    return properties
}

fun main(args: Array<String>) {

    val properties = readLocalProperties()
    val examplePath = properties["examplePath"].toString()
    val exportPath = properties["blogExportPath"].toString()

    Files.walk(Paths.get(examplePath)).use({ paths ->
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

                    val authorRegex = "Author:(.*)".toRegex()
                    val author = tokenize(fileContents, authorRegex)

                    val codeRegex = "\\*/(.*)".toRegex(RegexOption.DOT_MATCHES_ALL)
                    val code = tokenize(fileContents, codeRegex)

                    createFile(FileDescriptor(name, fileName, intro, outro, publish, author, code), exportPath)
                })
    })
}

fun createFile(fileDescriptor: FileDescriptor, path: String) {
    File("$path/${fileDescriptor.publish}-${fileDescriptor.fileName}.md").bufferedWriter().use { out ->
        out.writeLn("---")
        out.writeLn("title: \"${fileDescriptor.name}\"")
        out.writeLn("excerpt: \"${fileDescriptor.intro}\"")
        out.writeLn("date: \"${fileDescriptor.publish}\"")
        out.writeLn("author: " + if (!fileDescriptor.author.isNullOrBlank()) fileDescriptor.author else "Marcos Placona")
        out.writeLn("header:")
        out.writeLn("    og_image: assets/images/screenshots/${fileDescriptor.fileName}.png")
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