package com.github.senocak.blog

interface Document {
    fun put(key: String, value: Any)
    fun get(key: String): Any?
}

abstract class AbstractDocument: Document {
    private val properties: MutableMap<String, Any?> = HashMap()

    override fun put(key: String, value: Any): Unit {
        properties[key] = value
    }
    override fun get(key: String): Any? = properties[key]
}

enum class Property {
    TYPE, PRICE, MODEL
}

interface HasType : Document {
    val type: String?
        get() = get(key = Property.TYPE.toString()) as String?
}

interface HasPrice : Document {
    val price: Number?
        get() = get(key = Property.PRICE.toString()) as Number?
}

interface HasModel : Document {
    val model: String
        get() = get(key = Property.MODEL.toString()) as String
}

private class Car: AbstractDocument(), HasModel, HasType, HasPrice

fun main() {
    println("Constructing car")
    val car1 = Car()
        .also {
            it.put(key = Property.TYPE.toString(), value = "car")
            it.put(key = Property.MODEL.toString(), value = "300SL")
            it.put(key = Property.PRICE.toString(), value = 10000L)
        }
    println("Here is our car:")
    println("-> type: ${car1.type}")
    println("-> model: ${car1.model}")
    println("-> price: ${car1.price}")
}
/*
Constructing car
Here is our car:
-> type: car
-> model: 300SL
-> price: 10000
 */