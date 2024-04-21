package com.github.senocak.blog

import java.util.Collections
import kotlin.system.measureTimeMillis


val list: MutableList<String> = ArrayList<String>()
    .also {
        it.add("one")
        it.add("two")
        it.add("three")
    }
val set: MutableSet<String> = HashSet<String>()
    .also {
        it.add("90")
        it.add("34")
        it.add("12")
        it.add("78")
        it.add("56")
    }

fun main() {
    //list()
    //set()
    //ConcurrentModificationException()
    //forEachRemaining()
    //listIterator()
    //customIterator()
    //customIterable()

    /*
    val list: MutableList<String> = ArrayList()
    for (i in 0..<50_000_000) {
        list.add(element = i.toString())
    }
    iteratorPerformansTest(list = list)
    forEachPerformansTest(list = list)
    forPerformansTest(list = list)
    whilePerformansTest(list = list)
    doWhilePerformansTest(list = list)
    streamPerformansTest(list = list)
    streamParallelPerformansTest(list = list)
    recursivePerformansTest(list = list, start = 0)
    */
    //collections()
    //setOf()
}

private fun list() {
    println(message = "-----------------List")
    val iterator: Iterator<String> = list.iterator()
    while (iterator.hasNext()) {
        println(message = "Element: ${iterator.next()}")
    }
    /*
    -----------------List
    Element: one
    Element: two
    Element: three
    */
}
private fun set() {
    println(message = "-----------------SET")
    val iterator: Iterator<String?> = set.iterator()
    while (iterator.hasNext()) {
        println(message = "Element: ${iterator.next()}")
    }
    /*
    -----------------SET
    Element: 34
    Element: 12
    Element: 78
    Element: 56
    Element: 90
    */
}
private fun ConcurrentModificationException() {
    println(message = "-----------------ConcurrentModificationException")
    val iterator: Iterator<String> = list.iterator()
    list.add("five")
    //list.remove(element = "four")
    //list.removeAt(index = 0)
    while (iterator.hasNext()) {
        println(message = "Element: ${iterator.next()}")
    }
    /*
    -----------------ConcurrentModificationException
    Exception in thread "main" java.util.ConcurrentModificationException
        at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
        at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
        at com.github.senocak.blog.CollectionlarKt.main(collectionlar.kt:35)
        at com.github.senocak.blog.CollectionlarKt.main(collectionlar.kt)
    */
}
private fun forEachRemaining() {
    println(message = "-----------------forEachRemaining")
    list.iterator().forEachRemaining { println(message = it) }
    /*
    -----------------forEachRemaining
    one
    two
    three
    */
}
private fun listIterator() {
    println(message = "-----------------listIterator")
    val listIterator = list.listIterator()
    listIterator.add("five") // listenin en başına ekliyor
    while (listIterator.hasNext()) {
        val s = listIterator.next()
        println(message = "next: $s hashcode: ${s.hashCode()}")
    }
    println(message = "-----------------")
    while (listIterator.hasPrevious()) {
        val s = listIterator.previous()
        println(message = "next: $s hashcode: ${s.hashCode()}")
    }
    println(message = list)
    /*
    -----------------listIterator
    next: one hashcode: 110182
    next: two hashcode: 115276
    next: three hashcode: 110339486
    -----------------
    next: three hashcode: 110339486
    next: two hashcode: 115276
    next: one hashcode: 110182
    next: five hashcode: 3143346
    [five, one, two, three]
    */
}
private fun customIterator(){
    class CustomListIterator<T>(private val source: List<T>) : Iterator<T> {
        private var index = 0
        override fun hasNext(): Boolean = (this.index < source.size)
            .also { println(message = "hasNext: $it index: ${this.index} size: ${source.size}") }
        override fun next(): T = source[index++]
    }
    println(message = "-----------------custom iterator")
    val iterator = CustomListIterator(source = list)
    while (iterator.hasNext()) {
        println(message = "Element: ${iterator.next()}")
    }
    /*
    -----------------custom iterator
    hasNext: true index: 0 size: 3
    Element: one
    hasNext: true index: 1 size: 3
    Element: two
    hasNext: true index: 2 size: 3
    Element: three
    hasNext: false index: 3 size: 3
    */
}
private fun customIterable() {
    class Kisi(val isim: String, val yas: Int)
    class Kisiler: Iterable<Kisi> {
        private val persons: MutableList<Kisi> = ArrayList<Kisi>()
            .also {
                it.add(element = Kisi(isim = "John", yas = 30))
                it.add(element = Kisi(isim = "Jane", yas = 25))
                it.add(element = Kisi(isim = "Jack", yas = 20))
            }
        override fun iterator(): Iterator<Kisi> = persons.iterator().also { println(message = "returned iterator") }
    }
    val list = Kisiler()
    val it: Iterator<Kisi> = list.iterator()
    while (it.hasNext()) {
        val p: Kisi = it.next()
        println(message = "İsim: ${p.isim}, yaş: ${p.yas}")
    }
    /*
    returned iterator
    İsim: John, yaş: 30
    İsim: Jane, yaş: 25
    İsim: Jack, yaş: 20
    */
}

private fun iteratorPerformansTest(list: List<String>) {
    val timeInMillis = measureTimeMillis {
        val iterator = list.iterator()
        while (iterator.hasNext()) {
            val obj: Any = iterator.next()
        }
    }
    println(message = "Time taken after iterator: $timeInMillis")
}
private fun forEachPerformansTest(list: List<String>) {
    val timeInMillis = measureTimeMillis {
        for (element in list) {
            val obj: Any = element
        }
    }
    println("Time taken foreach: $timeInMillis")
}
private fun forPerformansTest(list: List<String>) {
    val timeInMillis = measureTimeMillis {
        for (i in list.indices) {
            val obj: Any = list[i]
        }
    }
    println("Time taken for loop: $timeInMillis")
}
private fun whilePerformansTest(list: List<String>) {
    val timeInMillis = measureTimeMillis {
        var i = 0
        while (i < list.size) {
            val obj: Any = list[i]
            i++
        }
    }
    println("Time taken while: $timeInMillis")
}
private fun doWhilePerformansTest(list: List<String>) {
    var i = 0
    val timeInMillis = measureTimeMillis {
        do {
            val obj: Any = list[i]
            i++
        } while (i < list.size)
    }
    println("Time taken do while: $timeInMillis")
}
private fun streamPerformansTest(list: List<String>) {
    val timeInMillis = measureTimeMillis {
        list.stream().forEach { val obj: Any = it }
    }
    println("Time taken stream: $timeInMillis")
}
private fun streamParallelPerformansTest(list: List<String>) {
    val timeInMillis = measureTimeMillis {
        list.stream().parallel().forEach { val obj: Any = it }
    }
    println("Time taken stream parallel: $timeInMillis")
}
private fun recursivePerformansTest(list: List<String>, start: Int) {
    // StackOverflowError
    if (start < list.size) {
        val obj: Any = list[start]
        recursivePerformansTest(list=list, start=start + 1)
    }
}
/*
Time taken after iterator: 56
Time taken foreach: 830
Time taken for loop: 7
Time taken while: 42
Time taken do while: 40
Time taken stream: 782
Time taken stream parallel: 155
Exception in thread "main" java.lang.StackOverflowError
*/
private fun collections() {
    list.add(index = 1, element = "four")
    val index = Collections.binarySearch(list, "two")
    println(message = "Index: $index")
    println(message = list)
    // Index: 1
}
private fun setOf() {
    java.util.Set.of("val1", "val2", "val3")
    setOf("val1", "val2", "val3") // Kotlin impl
}
