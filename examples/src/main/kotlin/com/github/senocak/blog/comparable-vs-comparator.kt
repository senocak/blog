package com.github.senocak.blog

fun main() {
    println(message = "Compare To 'a' b is : ${"a".compareTo(other = "b")}")
    println(message = "Compare To 'b' a is : ${"b".compareTo(other = "a")}")
    println(message = "Compare To 'b' b is : ${"b".compareTo(other = "b")}")
    //Compare To 'a' b is : -1
    //Compare To 'b' a is : 1
    //Compare To 'b' b is : 0

    data class Person(val name: String, val age: Int)
    val people = listOf(
        Person(name = "Alice", age = 30),
        Person(name = "Bob", age = 25),
        Person(name = "Charlie", age = 35)
    )

    // Sorting by age using a Comparator
    val ageComparator = Comparator<Person> { p1, p2 -> p1.age.compareTo(other = p2.age) }
    // Comparator for comparing people based on their name and age for equality
    //val equalityComparator = Comparator<Person> { p1, p2 -> if (p1.name == p2.name && p1.age == p2.age) 0 else -1 }
    val sortedByAge = people.sortedWith(ageComparator)

    println(message = "People sorted by age:")
    sortedByAge.forEach { println(message = "${it.name}, ${it.age} years old") }
    //People sorted by age:
    //Bob, 25 years old
    //Alice, 30 years old
    //Charlie, 35 years old
}
