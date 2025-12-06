package com.example.kmp_sample.articles

import com.example.kmp_sample.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticleViewModel : BaseViewModel() {

    private var _articleState = MutableStateFlow<ArticleState>(ArticleState.Loading)
    val articleState: StateFlow<ArticleState> = _articleState

    lateinit var articleUseCase: ArticleUseCase

    init {
        val httpClient = HttpClient {
            install(ContentNegotiation){
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
        val articleService = ArticleService(httpClient)
        articleUseCase = ArticleUseCase(articleService)

        getArticles()
    }

    fun getArticles() {
        scope.launch {
            _articleState.emit(ArticleState.Loading)
            val response = articleUseCase.invoke()
            _articleState.emit(ArticleState.Success(response))
        }
    }

    fun getMockList(): List<Article> {
        val items = mutableListOf<Article>()
        items.add(Article("Title", "Description1", "Content1", "Url1"))
        items.add(Article("Title2", "Description2", "Content2", "Url2"))
        items.add(Article("Title3", "Description3", "Content3", "Url3"))
        return items
    }


}