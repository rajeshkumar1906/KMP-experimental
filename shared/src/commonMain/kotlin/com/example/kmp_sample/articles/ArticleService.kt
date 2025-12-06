package com.example.kmp_sample.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get

class ArticleService(private  val httpClient: HttpClient) {

   suspend fun getArticles(): ArrayList<ArticleResponseItem> {
        val response: ArticleResponse = httpClient.get("https://newsdata.io/api/1/latest?apikey=pub_8f8d0fe0880747c085a68ac8c1b6ece3&q=technology").body()
       return response.articleList

    }
}