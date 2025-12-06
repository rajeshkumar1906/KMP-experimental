package com.example.kmp_sample.articles


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
//import android.support.annotation.Keep
@Serializable
data class ArticleResponse(
    val articleList: ArrayList<ArticleResponseItem> = ArrayList<ArticleResponseItem>()
)