package com.example.kmp_sample.articles


class ArticleUseCase(private val articleService: ArticleService){

    operator suspend fun invoke(): ArrayList<Article> {
        val response = articleService.getArticles()
        return modifiedList(response)
    }


    fun modifiedList(respose: ArrayList<ArticleResponseItem>): ArrayList<Article>{
        val list = ArrayList<Article>()
        respose.forEach {
            list.add(Article(it.title, it.description, it.content, it.imageUrl))
        }
        return list
    }

}