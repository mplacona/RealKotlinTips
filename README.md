# About
This is the repository for all the unit tested examples you will find in [RealKotlin.com](https://www.realkotlin.com)

## Contact
- [Twitter](https://twitter.com/marcos_placona)
- [Github](https://github.com/mplacona)
- [Blog](https://www.placona.co.uk)

## Contributing
I would ❤️ some contributions from other authors here. Just follow these steps

 - Fork this repository
 - Create a new test in `src/test/kotlin/Examples` using the "Real Kotlin Spek" file template. `File > New > Real Kotlin Spek`. Tests are written using [Spek Framework](http://spekframework.org/docs/latest/).

![realkotlinspek50](https://user-images.githubusercontent.com/221627/39075622-8109c164-44ee-11e8-9208-87f77ff31afc.gif) 

 - Create a new "Real Kotlin File" in `src/main/kotlin/Examples` using the provided template. `File > New > Real Kotlin File`
![realkotlinfile](https://user-images.githubusercontent.com/221627/39075920-42ef3f1a-44f0-11e8-89e5-a9362c671b00.gif)
 - Send me a pull request with everything
 - 🤗 wait for my virtual hug and for your code to be sent to all [RealKotlin.com](https://www.realkotlin.com) subscribers.
 - Bask in the glory of being an Open Source contributor

## Contributing - The extra mile
Posts are automatically generated after each example, which gets converted into markdown using the metadata added in JavaDocs style at the top of each file.

To generate posts and run them locally and make sure everything looks good, clone [this repository](https://github.com/mplacona/realkotlin.com) and check its README file to see how to [run the website](https://github.com/mplacona/realkotlin.com#running).

1. In the file-root of the website copy the path to `_tutorials` 
2. Back in this Kotlin project 👆 rename `sample-local.properties` to `local.properties`. 
3. In that file add the path to `_tutorials` you've copied into `blogExportPath`
4. for the `examplePath`, copy the absolute path to `src/main/kotlin/examples`.
5. Now run `gradle runGenerator` or open `Parser/JavadocParser.kt` and run its `main` function.
6. The new markdown file will get created in the website's folder.
7. Ah... that warm feeling of automation 💃
8. I'll take care of the publish date and adding you as the author.
