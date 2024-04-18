package com.github.senocak.blog

class Counter {
    private var count = 0

    // Method to increment the counter safely
    fun increment() {
        synchronized(this) {
            count++
            println(message = "Counter incremented: $count, ${Thread.currentThread().name}")
        }
    }

    // Method to decrement the counter safely
    fun decrement() {
        synchronized(this) {
            count--
            println(message = "Counter decremented: $count, ${Thread.currentThread().name}")
        }
    }

    // Method to get the current value of the counter
    fun getCount(): Int {
        synchronized(this) {
            return count
        }
    }
}

fun main() {
    val counter = Counter()

    // Creating multiple threads to concurrently access and modify the counter
    val thread1 = Thread { repeat(times = 5) { counter.increment() } }
    val thread2 = Thread { repeat(times = 5) { counter.decrement() } }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()

    println(message = "Final counter value: ${counter.getCount()}")
}
/*
Counter incremented: 1, Thread-0
Counter incremented: 2, Thread-0
Counter incremented: 3, Thread-0
Counter incremented: 4, Thread-0
Counter incremented: 5, Thread-0
Counter decremented: 4, Thread-1
Counter decremented: 3, Thread-1
Counter decremented: 2, Thread-1
Counter decremented: 1, Thread-1
Counter decremented: 0, Thread-1
Final counter value: 0
*/