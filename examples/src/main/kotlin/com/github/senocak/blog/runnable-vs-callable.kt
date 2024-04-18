package com.github.senocak.blog

import java.util.concurrent.Callable

fun main() {
    WorkRunnable().run()
    WorkCallable().call()
}

class WorkRunnable : Runnable {
    override fun run() {
        try {
            println(message = "Task started")
            Thread.sleep(1000)
            Thread.currentThread()
                .apply {
                    println(message = "Thread ${this.name} with state ${this.state}")
                }
        } catch (e: InterruptedException) {
            println(message = "InterruptedException ${e.message}")
        }
    }
}

class WorkCallable : Callable<String> {
    override fun call(): String {
        try {
            println(message = "Task started")
            Thread.sleep(1000)
            Thread.currentThread()
                .apply {
                    println(message = "Thread ${this.name} with state ${this.state}")
                }
        } catch (e: InterruptedException) {
            println(message = "InterruptedException ${e.message}")
        }
        return "Task done"
    }
}