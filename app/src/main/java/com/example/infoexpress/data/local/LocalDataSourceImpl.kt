package com.example.infoexpress.data.local

import com.example.infoexpress.data.dao.ArticleDao
import com.example.infoexpress.data.entity.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dao: ArticleDao
) : LocalDataSource {
    override fun getArticles(): Flow<List<Article>> {
        return dao.getArticles()
    }

    override fun insertArticle(article: Article) {
        dao.insertArticle(article)
    }

    override fun deleteArticle(article: Article) {
        dao.deleteArticle(article)
    }
}