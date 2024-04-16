package examples

import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ImageClient {
    val imagePath: String?
        get() {
            val httpGet = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:50005/image-path"))
                .build()
            return try {
                val httpResponse = HttpClient.newHttpClient().send(httpGet, BodyHandlers.ofString())
                httpResponse.body()
            } catch (e: IOException) {
                println("IOException: ${e.message}")
                null
            } catch (e: InterruptedException) {
                println("InterruptedException: ${e.message}")
                null
            }
        }
}

class PriceClient {
    val price: String?
        get() {
            val httpGet = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:50006/price"))
                .build()
            return try {
                val httpResponse = HttpClient.newHttpClient().send(httpGet, BodyHandlers.ofString())
                httpResponse.body()
            } catch (e: IOException) {
                println("IOException: ${e.message}")
                null
            } catch (e: InterruptedException) {
                println("InterruptedException: ${e.message}")
                null
            }
        }
}

fun main() {
    val imageClient = ImageClient()
    val priceClient = PriceClient()
    println("imageClient: ${imageClient.imagePath}")
    println("priceClient: ${priceClient.price}")
}
