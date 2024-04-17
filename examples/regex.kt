package examples

fun main() {
    println(message = "-------------------------Matching")
    var regex = """a([bc]+)d?""".toRegex()
    println(message = regex.containsMatchIn(input = "xabcdy")) // true
    println(message = regex.matches(input = "abcd")) // true
    println(message = regex matches "xabcdy") // false

    println(message = "-------------------------Extracting Matching Components")
    var matchResult = regex.matchEntire(input = "abbccbbd")
    println(message = matchResult?.value) // abbccbbd
    matchResult = regex.find(input = "abcbabbd")
    println(message = matchResult?.value) // abcb
    val matchResults = regex.findAll(input = "abcb abbd")
    println(message = matchResults.toList().map { it.value }) // [abcb, abbd]

    println(message = "-------------------------The MatchResult Class")
    regex = """a([bc]+)d?""".toRegex()
    matchResult = regex.find(input = "abcb abbd")
    println(message = "abcb" == matchResult?.value) // true
    println(message = IntRange(0, 3) == matchResult?.range) // true

    println(message = "-------------------------Groups and Destructuring")
    println(message = listOf("abcb", "bcb") == matchResult?.groupValues) // true
    println(message = IntRange(1, 3) == matchResult!!.groups[1]?.range) // true

    regex = """([\w\s]+) is (\d+) years old""".toRegex()
    matchResult = regex.find(input = "Mickey Mouse is 95 years old")!!
    var (name, age) = matchResult.destructured
    println(message = "Mickey Mouse" == name) // true
    println(message = "95" == age) // true

    println(message = "-------------------------Capture Groups by Name")
    regex = """(?<name>[\w\s]+) is (?<age>\d+) years old""".toRegex()
    matchResult = regex.find(input = "Mickey Mouse is 95 years old")!!

    age = matchResult.groups["age"]?.value!!
    name = matchResult.groups["name"]?.value!!

    println(message = "Mickey Mouse" == name) // true
    println(message = "95" == age) // true

    println(message = "-------------------------Multiple Matches")
    regex = """a([bc]+)d?""".toRegex()
    matchResult = regex.find(input = "abcb abbd")

    println(message = "abcb" == matchResult!!.value) // true

    matchResult = matchResult.next()
    println(message = "abbd" == matchResult!!.value) // true

    matchResult = matchResult.next()
    println(message = matchResult) // null

    println(message = "-------------------------Replacing")
    regex = """(red|green|blue)""".toRegex()
    val beautiful = "Roses are red, Violets are blue"
    val grim = regex.replace(input = beautiful, replacement = "dark")
    println(message = "Roses are dark, Violets are dark" == grim) // true

    val shiny = regex.replaceFirst(input = beautiful, replacement = "rainbow")
    println(message = "Roses are rainbow, Violets are blue" == shiny) // true

    println(message = "-------------------------Complex Replacements")
    val reallyBeautiful = regex.replace(input = beautiful) { m -> m.value.uppercase() + "!" }
    println(message = "Roses are RED!, Violets are BLUE!" == reallyBeautiful) // true

    println(message = "-------------------------Splitting")
    regex = """\W+""".toRegex()
    println(message = listOf("Roses", "are", "red", "Violets", "are", "blue") == regex.split(input = beautiful)) // true
}