package com.github.senocak.blog

import kotlin.system.measureTimeMillis

fun main() {
    var s = "bir"
    println(message = s.hashCode())
    s = "iki"
    println(message = s.hashCode())
    //97547
    //104327
    println("-----------------")
    var stringBuffer1 = StringBuffer("üç")
    println(message = "$stringBuffer1 -> ${stringBuffer1.hashCode()}")
    stringBuffer1 = stringBuffer1.append("dört")
    println(message = "$stringBuffer1 -> ${stringBuffer1.hashCode()}")
    stringBuffer1 = stringBuffer1.insert(5, "beş")
    println(message = "$stringBuffer1 -> ${stringBuffer1.hashCode()}")
    //üç -> 1670782018
    //üçdört -> 1670782018
    //üçdörbeşt -> 1670782018
    println("-----------------")
    var stringBuilder1 = StringBuilder("altı")
    println(message = "$stringBuilder1 -> ${stringBuilder1.hashCode()}")
    stringBuilder1 = stringBuilder1.append("yedi")
    println(message = "$stringBuilder1 -> ${stringBuilder1.hashCode()}")
    stringBuilder1 = stringBuilder1.insert(5, "sekiz")
    println(message = "$stringBuilder1 -> ${stringBuilder1.hashCode()}")
    //altı -> 989110044
    //altıyedi -> 989110044
    //altıysekizedi -> 989110044

    measureTimeMillis {
        val strbuffer = StringBuffer("Hello")
        for (i in 0..100_000) {
            strbuffer.append(i)
        }
    }
        .also { println("StringBuffer Geçen Süre: $it ms") }
    measureTimeMillis {
        val strbuffer = StringBuilder("Hello")
        for (i in 0..100_000) {
            strbuffer.append(i)
        }
    }
        .also { println("StringBuilder Geçen Süre: $it ms") }
}