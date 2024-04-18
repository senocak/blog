package com.github.senocak.blog

fun main() {
    //Collection'lar genel olarak verileri tutmak için kullanılır
    val names = arrayListOf("Ornek", "Collection", "Stream")

    //Stream'ler genel olarak veiler üzerinde işlem yapmak için kullanılır
    names.stream().forEach { x: String -> print(message = "$x,") } // Ornek,Collection,Stream,

    println(message = "\n----------External Iteration")
    for (x in names)
        print(message = "$x,") // Ornek,Collection,Stream,
    println(message = "\n----------Internal Iteration")
    names.stream().map { it.uppercase() }.forEach { x: String -> print(message = "$x,") } // ORNEK,COLLECTION,STREAM,


    println(message = "\n----------Geçiş")
    val numbersGreaterThan5 = names.stream()
    numbersGreaterThan5.forEach { print(message = "$it,") } // Ornek,Collection,Stream,
    numbersGreaterThan5.forEach { print(message = "$it,") } //IllegalStateException : stream has already been operated upon or closed

    names.stream().limit(3).forEach { println(message = it) }
}