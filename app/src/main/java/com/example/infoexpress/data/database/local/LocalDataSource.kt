package com.example.infoexpress.data.database.local

import com.example.infoexpress.data.database.entity.Article
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow

@Module
interface LocalDataSource {
    @Provides
    fun getArticles(): Flow<List<Article>>
    @Provides
    fun insertArticle(article: Article)
    @Provides
    fun deleteArticle(article: Article)
}
