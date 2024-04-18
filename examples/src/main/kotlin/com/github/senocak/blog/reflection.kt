package com.github.senocak.blog

import java.lang.reflect.Modifier
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.functions
import kotlin.reflect.jvm.isAccessible

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE)
annotation class OrnekAnnotation

class OrnekSinif {
    constructor(name: String? = "anil", country: String? = "anil") {
        println(message = "second constructor")
    }

    @OrnekAnnotation
    private lateinit var yas: String
    private fun ornekMetod1(p: Any?, x: Int): Int =
        when (p) {
            null -> throw NullPointerException()
            else -> x
        }
    @OrnekAnnotation
    private fun ornekMetod2(): String = TODO()
}

fun main() {
    val c = Class.forName("com.github.senocak.blog.OrnekSinif")
    for (method in c.declaredMethods)
        println(message = method.toString())
    //OrnekSinif::class.java.methods.forEach(::println)
    //private final int examples.OrnekSinif.ornekMetod1(java.lang.Object,int)
    //private final java.lang.String examples.OrnekSinif.ornekMetod2()

    val kClass = OrnekSinif::class
    println(message = kClass.members)
    // [fun com.github.senocak.blog.OrnekSinif.ornekMetod1(kotlin.Any?, kotlin.Int): kotlin.Int, fun com.github.senocak.blog.OrnekSinif.ornekMetod2(): kotlin.String, fun com.github.senocak.blog.OrnekSinif.equals(kotlin.Any?): kotlin.Boolean, fun com.github.senocak.blog.OrnekSinif.hashCode(): kotlin.Int, fun com.github.senocak.blog.OrnekSinif.toString(): kotlin.String]

    //isInstance(c = c)
    //isInstanceKotlin(c = OrnekSinif::class)
    //declaredMethods(c = c)
    //declaredMethodsKotlin(c = OrnekSinif::class)
    //declaredConstructors(c = c)
    //declaredConstructorsKotlin(c = OrnekSinif::class)
    //methodCallKotlin(c = OrnekSinif::class)
    createInstance(c = OrnekSinif::class)
}

fun isInstance(c: Class<*>) {
    println(message = "---------------------isInstance")
    println(message = c.isInstance(37)) // false
    println(message = c.isInstance(OrnekSinif())) // true
}
fun isInstanceKotlin(c: KClass<*>) {
    println(message = "---------------------isInstanceKotlin")
    println(message = c.isInstance(37)) // false
    println(message = c.isInstance(OrnekSinif())) // true
}
fun declaredMethods(c: Class<*>) {
    println(message = "---------------------declaredMethods")
    for (m in c.declaredMethods) {
        println(message = "name = ${m.name}") // name = ornekMetod1
        println(message = "declaringClass = ${m.declaringClass}") // declaringClass = class com.github.senocak.blog.OrnekSinif
        m.parameterTypes.indices.toList().also { println(message = "parameterTypes: $it") }
        m.exceptionTypes.indices.toList().also { println(message = "exceptionTypes: $it") }
        println(message = "returnType = ${m.returnType}")
    }
    /*
    ---------------------isInstance
    name = ornekMetod1
    declaringClass = class com.github.senocak.blog.OrnekSinif
    parameterTypes: [0, 1]
    exceptionTypes: []
    returnType = int
    name = ornekMetod2
    declaringClass = class com.github.senocak.blog.OrnekSinif
    parameterTypes: []
    exceptionTypes: []
    returnType = class java.lang.String
    */
}
fun declaredMethodsKotlin(c: KClass<*>) {
    println(message = "---------------------isInstanceKotlin")
    c.functions.forEach {
        println(message = "name: ${it.name}")
        println("declaringClass: ${it.returnType}")
        println("visibility: ${it.visibility}")
        println("isAccessible: ${it.isAccessible}")
        println("isOpen: ${it.isOpen}")
        println("isAbstract: ${it.isAbstract}")
        println("isFinal: ${it.isFinal}")
        println("isSuspend: ${it.isSuspend}")
        println("isExternal: ${it.isExternal}")
        println("isInline: ${it.isInline}")
        println("isInfix: ${it.isInfix}")
        println("isOperator: ${it.isOperator}")
        println("annotations: ${it.annotations}")
        println("parameters: ${it.parameters}")
        println("typeParameters: ${it.typeParameters}")
    }
    /*
    ---------------------isInstance Kotlin
    name: ornekMetod1
    declaringClass: kotlin.Int
    visibility: PRIVATE
    isAccessible: false
    isOpen: false
    isAbstract: false
    isFinal: true
    isSuspend: false
    isExternal: false
    isInline: false
    isInfix: false
    isOperator: false
    annotations: []
    parameters: [instance parameter of fun com.github.senocak.blog.OrnekSinif.ornekMetod1(kotlin.Any?, kotlin.Int): kotlin.Int, parameter #1 p of fun com.github.senocak.blog.OrnekSinif.ornekMetod1(kotlin.Any?, kotlin.Int): kotlin.Int, parameter #2 x of fun com.github.senocak.blog.OrnekSinif.ornekMetod1(kotlin.Any?, kotlin.Int): kotlin.Int]
    typeParameters: []
    name: ornekMetod2
    declaringClass: kotlin.String
    visibility: PRIVATE
    isAccessible: false
    isOpen: false
    isAbstract: false
    isFinal: true
    isSuspend: false
    isExternal: false
    isInline: false
    isInfix: false
    isOperator: false
    annotations: [@com.github.senocak.blog.OrnekAnnotation()]
    parameters: [instance parameter of fun com.github.senocak.blog.OrnekSinif.ornekMetod2(): kotlin.String]
    typeParameters: []
    name: equals
    declaringClass: kotlin.Boolean
    visibility: PUBLIC
    isAccessible: false
    isOpen: true
    isAbstract: false
    isFinal: false
    isSuspend: false
    isExternal: false
    isInline: false
    isInfix: false
    isOperator: true
    annotations: []
    parameters: [instance parameter of fun com.github.senocak.blog.OrnekSinif.equals(kotlin.Any?): kotlin.Boolean, parameter #1 other of fun com.github.senocak.blog.OrnekSinif.equals(kotlin.Any?): kotlin.Boolean]
    typeParameters: []
    name: hashCode
    declaringClass: kotlin.Int
    visibility: PUBLIC
    isAccessible: false
    isOpen: true
    isAbstract: false
    isFinal: false
    isSuspend: false
    isExternal: false
    isInline: false
    isInfix: false
    isOperator: false
    annotations: []
    parameters: [instance parameter of fun com.github.senocak.blog.OrnekSinif.hashCode(): kotlin.Int]
    typeParameters: []
    name: toString
    declaringClass: kotlin.String
    visibility: PUBLIC
    isAccessible: false
    isOpen: true
    isAbstract: false
    isFinal: false
    isSuspend: false
    isExternal: false
    isInline: false
    isInfix: false
    isOperator: false
    annotations: []
    parameters: [instance parameter of fun com.github.senocak.blog.OrnekSinif.toString(): kotlin.String]
    typeParameters: []
    */
}
fun declaredConstructors(c: Class<*>) {
    println(message = "---------------------declaredConstructors")
    for (ct in c.declaredConstructors) {
        println("name = ${ct.name}")
        println("decl class = ${ct.declaringClass}")
        ct.parameterTypes.indices.toList().also { println(message = "parameterTypes: $it") }
        ct.exceptionTypes.indices.toList().also { println(message = "exceptionTypes: $it") }
    }
    /*
    ---------------------declaredConstructors
    name = com.github.senocak.blog.OrnekSinif
    decl class = class com.github.senocak.blog.OrnekSinif
    parameterTypes: []
    exceptionTypes: []
    */
}
fun declaredConstructorsKotlin(c: KClass<*>) {
    println(message = "---------------------declaredConstructorsKotlin")
    c.constructors.forEach {
        println(message = "name: ${it.name}")
        println("declaringClass: ${it.returnType}")
        println("visibility: ${it.visibility}")
        println("isAccessible: ${it.isAccessible}")
        println("isOpen: ${it.isOpen}")
        println("isAbstract: ${it.isAbstract}")
        println("isFinal: ${it.isFinal}")
        println("isSuspend: ${it.isSuspend}")
        println("isExternal: ${it.isExternal}")
        println("isInline: ${it.isInline}")
        println("isInfix: ${it.isInfix}")
        println("isOperator: ${it.isOperator}")
        println("annotations: ${it.annotations}")
        println("parameters: ${it.parameters}")
        println("typeParameters: ${it.typeParameters}")
        println("|")
    }
    /*
    ---------------------declaredConstructorsKotlin
    name: <init>
    declaringClass: com.github.senocak.blog.OrnekSinif
    visibility: PUBLIC
    isAccessible: false
    isOpen: false
    isAbstract: false
    isFinal: true
    isSuspend: false
    isExternal: false
    isInline: false
    isInfix: false
    isOperator: false
    annotations: []
    parameters: [parameter #0 name of fun `<init>`(kotlin.String?, kotlin.String?): com.github.senocak.blog.OrnekSinif, parameter #1 country of fun `<init>`(kotlin.String?, kotlin.String?): com.github.senocak.blog.OrnekSinif]
    typeParameters: []
    |
    name: <init>
    declaringClass: com.github.senocak.blog.OrnekSinif
    visibility: PUBLIC
    isAccessible: false
    isOpen: false
    isAbstract: false
    isFinal: true
    isSuspend: false
    isExternal: false
    isInline: false
    isInfix: false
    isOperator: false
    annotations: []
    parameters: [parameter #0 name of fun `<init>`(kotlin.String?): com.github.senocak.blog.OrnekSinif]
    typeParameters: []
    */
}
fun declaredFields(c: Class<*>) {
    println(message = "---------------------declaredFields")
    for (fld in c.declaredFields) {
        println(message = "name = ${fld.name}")
        println(message = "declaringClass = ${fld.declaringClass}")
        println(message = "type = ${fld.type}")
        println(message = "modifiers = " + Modifier.toString(fld.modifiers))
    }
    /*
    ---------------------declaredFields
    name = yas
    declaringClass = class com.github.senocak.blog.OrnekSinif
    type = class java.lang.String
    modifiers = private
    */
}
fun declaredFieldsKotlin(c: KClass<*>) {
    println(message = "---------------------declaredFields Kotlin")
    c.declaredMemberProperties.toList()
        .forEach {
            println(message = "name: ${it.name}")
            println("declaringClass: ${it.returnType}")
            println("visibility: ${it.visibility}")
            println("isAccessible: ${it.isAccessible}")
            println("isLateinit: ${it.isLateinit}")
            println("isOpen: ${it.isOpen}")
            println("isAbstract: ${it.isAbstract}")
            println("isFinal: ${it.isFinal}")
            println("isSuspend: ${it.isSuspend}")
            println("isConst: ${it.isConst}")
            println("getter: ${it.getter}")
            println("annotations: ${it.annotations}")
        }
    /*
    name: yas
    declaringClass: kotlin.String
    visibility: PRIVATE
    isAccessible: false
    isLateinit: true
    isOpen: false
    isAbstract: false
    isFinal: true
    isSuspend: false
    isConst: false
    getter: getter of var com.github.senocak.blog.OrnekSinif.yas: kotlin.String
    annotations: [@com.github.senocak.blog.OrnekAnnotation()]
    */
}
fun methodCallKotlin(c: KClass<*>) {
    println(message = "---------------------methodCallKotlin")
    (c.functions.find { it.name == "ornekMetod1" } ?: throw NullPointerException())
        .also {
            it.isAccessible = true
            println(message = "Result: ${it.call(c.createInstance(), "p", 5)}")
        }
    /*
    ---------------------methodCallKotlin
    second constructor
    Result: 5
    */
}
fun createInstance(c: KClass<*>) {
    println(message = "---------------------createInstance")
    println(message = "createInstance: ${c.createInstance()}")
    /*
    ---------------------createInstance
    second constructor
    createInstance: com.github.senocak.blog.OrnekSinif@448c8166
    */
}