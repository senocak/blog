package com.github.senocak.blog

fun main() {
    println(message = "----------Interface")
    Araba1(isim = "Tesla")
        .also { it.printIsim() }
        .also { it.printStates() }
    val test3 = object : IArac {
        var hiz: Int = 20
        var vites: Int = 21
        override val isim: String
            get() = "TOGG"

        override fun vites(yeniDeger: Int): Unit = run { vites = yeniDeger }
        override fun hizlan(artis: Int): Unit = run { hiz = hiz + artis }
        override fun fren(azalis: Int): Unit = run { hiz = hiz - azalis }
        fun printStates(): Unit = println(message = "Hız:$hiz vites:$vites")
    }
        .also { it.printIsim() }
        .also { it.printStates() }

    println(message = "----------Abstract")
    Porsche()
        .also { println(message = "Porsche: Kapı sayısı: ${it.kapiSayisi()}") }
        .also { println(message = "Porsche: Vites: ${it.vites()}") }
    Sahin()
        .also { println(message = "Sahin: Kapı Sayısı: ${it.kapiSayisi()}") }
        .also { println(message = "Sahin: Vites: ${it.vites()}") }

    /*
    ----------Interface
    IAraç: Tesla
    Hız:10 vites:11
    IAraç: TOGG
    Hız:20 vites:21
    ----------Abstract
    Porsche: Kapı sayısı: 2
    Porsche: Vites: 5
    Sahin: Kapı Sayısı: 4
    Sahin: Vites: 5
    */
}

internal interface IArac {
    val isim: String
    fun vites(yeniDeger: Int): Unit
    fun hizlan(artis: Int): Unit
    fun fren(azalis: Int): Unit
    fun printIsim(): Unit = println(message = "IAraç: $isim")
}

internal class Araba1(override val isim: String) : IArac {
    var hiz: Int = 10
    var vites: Int = 11

    override fun vites(yeniDeger: Int): Unit = run { vites = yeniDeger }
    override fun hizlan(artis: Int): Unit = run { hiz = hiz + artis }
    override fun fren(azalis: Int): Unit = run { hiz = hiz - azalis }
    fun printStates(): Unit = println(message = "Hız:$hiz vites:$vites")
}

internal abstract class AArac {
    abstract fun vites(): Int
    open fun kapiSayisi(): Int = 4
}

internal class Porsche : AArac() {
    override fun vites(): Int = 5
    override fun kapiSayisi(): Int = 2
}

internal class Sahin : AArac() {
    override fun vites(): Int = 5
}
