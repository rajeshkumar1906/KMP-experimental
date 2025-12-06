package com.example.kmp_sample.articles

import com.example.kmp_sample.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : BaseViewModel() {

    private var _articleState = MutableStateFlow<ArticleState>(ArticleState.Loading)
    val articleState: StateFlow<ArticleState> = _articleState


    init {
        getArticles()
    }

    fun getArticles() {
        scope.launch {
            _articleState.emit(ArticleState.Loading)
            delay(100)
            _articleState.emit(ArticleState.Success(getMockList()))
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