package examples

import java.util.stream.Collectors
import java.util.stream.Stream

fun main() {
    mutableListOf(20, 12, 4, 6, 2, 20)
        .apply {
            this.stream().allMatch { n: Int -> n % 3 == 0 }.also { println(message = "allMatch: $it") } // allMatch: false
            this.stream().anyMatch { n: Int -> n % 3 == 0 }.also { println(message = "anyMatch: $it") } // anyMatch: true
            this.stream().noneMatch { n: Int -> n % 21 == 0 }.also { println(message = "noneMatch: $it") } // anyMatch: true
            this.stream().filter { it > 9 }.collect(Collectors.toList()).also { println(message = "collect: $it") } // collect: [12, 20]
            this.stream().count().also { println(message = "count: $it") } // count: 3
            this.stream().max { x: Int, y: Int -> x.compareTo(other = y) }.get().also { println(message = "max: $it") } // max: 20
            this.stream().reduce { x: Int, y: Int -> if (x < y) x else y }.ifPresent { println(message = "reduce: $it") } // reduce: 3
            this.stream().map { it + 1}.collect(Collectors.toList()).also { println(message = "map: $it") } // map: [4, 5, 7, 13, 21]
            this.stream().map { "$it+${it + 1}" }.flatMap { line -> Stream.of(line.split('+')) }.toList().also { println(message = "flatMap: $it") } // flatMap: [[3, 4], [4, 5], [6, 7], [12, 13], [20, 21]]
            this.stream().distinct().toList().also { println(message = "distinct: $it") } // distinct: [3, 4, 6, 12, 20]
            this.stream().forEach { x: Int -> print(message = "$x,") } // 3,4,6,12,20,
        }
    mutableListOf("Ornek", "stream", "sort")
        .apply {
            this.stream().sorted().toList().also { println(message = "sorted: $it") } // sorted: [Ornek, sort, stream]
            this.stream().limit(2).toList().also { println(message = "limit: $it") } // limit: [Ornek, stream]
            this.stream().skip(2).toList().also { println(message = "skip: $it") } // skip: [sort]
            this.stream().filter { it.length > 2 }.peek { print("peek: $it,") }.map { it.uppercase() }.toList() // peek: Ornek,peek: stream,peek: sort,
        }
}