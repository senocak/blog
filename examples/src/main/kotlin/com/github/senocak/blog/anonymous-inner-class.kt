package com.github.senocak.blog

fun main() {
    val sinif = Sinif()
    println(message = "Yaş: ${sinif.yas}")
    // Yaş: 23

    val yas: Yas = object : Yas {
        override val yas: Int
            get() = 24
    }
    println(message = "Yaş: ${yas.yas}")
    // Yaş: 24

    val t: Thread = object : Thread() {
        override fun run() = println(message = "Child Thread")
    }
    t.start()

    val r = Runnable { println(message = "Runnable Child Thread") }
    Thread(r).start()
    println(message = "Main Thread")

    //Child Thread
    //Main Thread
    //Runnable Child Thread
}

internal interface Yas {
    val yas: Int
        get() = 21
}

class Sinif : Yas {
    override val yas: Int
        get() = 23
}
