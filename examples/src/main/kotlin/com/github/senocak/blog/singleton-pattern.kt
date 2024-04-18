package com.github.senocak.blog

class MySingleton private constructor() {
    init {
        println(message = "Singleton instance initialized")
    }
    companion object {
        val instance: MySingleton by lazy { MySingleton() }
    }
    fun printHasCode() = println(message = hashCode())
}

fun main() {
    MySingleton.instance.also { it.printHasCode() }
    //MySingleton() // Cannot access '<init>': it is private in 'MySingleton'
    MySingleton.instance.also { it.printHasCode() }
}
