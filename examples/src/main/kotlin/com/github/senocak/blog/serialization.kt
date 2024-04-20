package com.github.senocak.blog

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class OrnekSerializable(var marka: String, var model: String)//: java.io.Serializable

fun main() {
    val araba = OrnekSerializable(marka = "Togg", model = "T10X")
    /*
    val arabaYaz = java.io.ObjectOutputStream(java.io.FileOutputStream("araba.txt"))
    arabaYaz.writeObject(araba)
    arabaYaz.close()
    // araba.txt
    // ¬í^@^Esr^@)com.github.senocak.blog.OrnekSerializableÔ4)5´f:¿^B^@^BL^@^Emarkat^@^RLjava/lang/String;L^@^Emodelq^@~^@^Axpt^@^DSeatt^@^DLeon

    val read = java.io.ObjectInputStream(java.io.FileInputStream("araba.txt"))
    val arabaRead = read.readObject() as OrnekSerializable
    println(message = arabaRead.toString())
    read.close()
    // OrnekSerializable(marka=Togg, model=T10X)
    */

    val string = Json.encodeToString(value = araba)
    println(message = string)
    // {"marka":"Togg","model":"T10X"}

    val obj = Json.decodeFromString<OrnekSerializable>(string)
    println(message = obj)
    // OrnekSerializable(marka=Togg, model=T10X)
}