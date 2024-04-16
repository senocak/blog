package examples

import java.util.concurrent.ArrayBlockingQueue

val queue = ArrayBlockingQueue<Int>(10) // Shared data structure

// Producer class
class Producer(private val id: Int) : Thread() {
    override fun run() {
        for (i in 1..5) {
            try {
                val number = (Math.random() * 100).toInt() // Simulated data
                println(message = "Producer $id produced: $number")
                queue.put(number) // Put the produced data into the queue
                sleep((Math.random() * 1_000).toLong()) // Simulated processing time
            } catch (ex: InterruptedException) {
                println(message = "Producer: InterruptedException: ${ex.message}")
            }
        }
    }
}

// Consumer class
class Consumer(private val id: Int) : Thread() {
    override fun run() {
        while (true) {
            try {
                val number = queue.take() // Take data from the queue
                println(message = "Consumer $id consumed: $number")
                sleep((number * 1_000).toLong()) // Simulated processing time
            } catch (ex: InterruptedException) {
                println(message = "Consumer: InterruptedException: ${ex.message}")
            }
        }
    }
}

fun main() {
    val producers = Array(2) { Producer(it) } // Two producers
    val consumers = Array(3) { Consumer(it) } // Three consumers

    producers.forEach { it.start() } // Start producer threads
    consumers.forEach { it.start() } // Start consumer threads

    // Let the program run for a while
    Thread.sleep(10_000)

    // Interrupt all threads to stop the program
    producers.forEach { it.interrupt() }
    consumers.forEach { it.interrupt() }
}
