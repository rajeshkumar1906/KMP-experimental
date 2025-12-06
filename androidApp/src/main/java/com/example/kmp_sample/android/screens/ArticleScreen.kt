package com.example.kmp_sample.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmp_sample.android.Toolbar
import com.example.kmp_sample.articles.Article
import com.example.kmp_sample.articles.ArticleState
import com.example.kmp_sample.articles.ArticleState.Loading
import com.example.kmp_sample.articles.ArticleState.Success
import com.example.kmp_sample.articles.ArticleViewModel

@Composable
fun ArticleScreen(articleViewModel: ArticleViewModel){
    val articleState = articleViewModel.articleState.collectAsState()
    when(articleState.value){
        is ArticleState.Loading -> {}
        is ArticleState.Success -> {
            val articles = (articleState.value as ArticleState.Success).articles
            Content(articles)
        }
        is ArticleState.Error -> {}

    }

}

@Composable
fun Content(list: List<Article>){
    Column {
        Toolbar()
        ArticleList(list)
    }
}

@Composable
fun ArticleList(articles: List<Article>) {
    LazyColumn {
        items(articles.size) {
            ArticleItem(articles[it])
        }
    }
}

@Composable
fun ArticleItem(article: Article) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Title: ${article.title}")
        Text("Description: ${article.description}")
        Text("Content: ${article.content}")
        Text("Url: ${article.url}")
        Spacer(modifier = Modifier.height(16.dp))
    }
}