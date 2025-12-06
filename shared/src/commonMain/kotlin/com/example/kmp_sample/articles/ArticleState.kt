package com.example.kmp_sample.articles

sealed class ArticleState{
    object Loading: ArticleState()
    data class Success(val articles: List<Article>): ArticleState()
    data class Error(val message: String): ArticleState()
}
