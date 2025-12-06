package com.example.kmp_sample

import io.ktor.client.HttpClient
//import io.ktor.client.request.get
//import io.ktor.client.statement.bodyAsText

class Greeting {
//    private val platform: Platform = getPlatform()
//    private val client = HttpClient()

    suspend fun greet(): String {
//        val response = client.get("https://ktor.io/docs/")
//        return "Hello, ${response.bodyAsText()} from ${platform.name}!"
        return "Hello, from !"
    }
}