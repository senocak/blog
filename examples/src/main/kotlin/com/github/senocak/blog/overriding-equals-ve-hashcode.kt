package com.github.senocak.blog

internal class Bilgi(
    val soru: String,
    val cevap: String
){
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            other == null -> false
            javaClass != other.javaClass -> false
            else -> {
                val bilgi = other as Bilgi
                if (soru != bilgi.soru)
                    return false
                true
            }
        }
    }
    override fun hashCode(): Int = 31 + soru.hashCode()
}
fun main() {
    val bir = Bilgi(soru = "soru1", cevap = "cevap1")
    val iki = Bilgi(soru = "soru1", cevap = "cevap2")

    val sorular = HashSet<Bilgi>()
    sorular.add(element = bir)
    println(message = sorular.contains(iki))
    println(message = "bir.hashCode(): ${bir.hashCode()}  iki.hashCode(): ${iki.hashCode()}")
    // Hashcode override edilmeden
    //false
    //bir.hashCode(): 381259350  iki.hashCode(): 2129789493

    // Hashcode override edilince
    //true
    //bir.hashCode(): 109624977  iki.hashCode(): 109624977
}