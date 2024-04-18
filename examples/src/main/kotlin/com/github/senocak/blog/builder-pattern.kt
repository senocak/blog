package com.github.senocak.blog

class Araba private constructor(
    val marka: String,
    val model: String,
    val yil: Int,
    val renk: String,
    val beygir: Int
) {
    internal class Builder {
        private lateinit var marka: String
        private lateinit var model: String
        private var yil: Int = 0
        private lateinit var renk: String
        private var beygir: Int = 0

        fun marka(marka: String) = apply { this.marka = marka }
        fun model(model: String) = apply { this.model = model }
        fun yil(yil: Int) = apply { this.yil = yil }
        fun renk(renk: String) = apply { this.renk = renk }
        fun beygir(beygir: Int) = apply { this.beygir = beygir }

        fun build(): Araba =
            require(value = yil > 0) { "Yıl zorunlu" }
                .run { Araba(marka = marka, model = model, yil = yil, renk = renk, beygir = beygir) }
    }
    override fun toString(): String = "Araba(marka='$marka', model='$model', yil=$yil, renk='$renk', beygir=$beygir)"
}

fun main() {
    Araba.Builder()
        .marka("Toyota")
        .model("Camry")
        .yil(2022)
        .renk("Red")
        .beygir(203)
        .build()
        .also { println(message = it) }
    // Araba(marka='Toyota', model='Camry', yil=2022, renk='Red', beygir=203)
}
