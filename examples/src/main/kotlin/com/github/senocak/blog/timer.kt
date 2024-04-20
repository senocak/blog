package com.github.senocak.blog

import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.timer

fun main() {
    val task: TimerTask = object : TimerTask() {
        var seconds: Int = 5
        override fun run() {
            println(message = "Kalan Zaman: ${seconds--}")
            if (seconds < 0)
                seconds = 5
        }
    }
    Timer().schedule(task, 0, 1000)
    /*
    Kalan Zaman: 5
    Kalan Zaman: 4
    Kalan Zaman: 3
    Kalan Zaman: 2
    Kalan Zaman: 1
    Kalan Zaman: 0
    Kalan Zaman: 5
    Kalan Zaman: 4
    ...
    */
    timer(name = "timer", initialDelay = 1000L, period = 1000L ) {
        println(message = "scheduledExecutionTime: ${this.scheduledExecutionTime()}")
    }
    fixedRateTimer(name = "fixedRateTimer", initialDelay = 1000, period = 1000, daemon = true) {
        println(message = "scheduledExecutionTime: ${this.scheduledExecutionTime()}")
    }
}