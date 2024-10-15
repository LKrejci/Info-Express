package com.example.infoexpress.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.infoexpress.data.entity.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Upsert
    fun insertArticle(article: Article)

    @Delete
    fun deleteArticle(article: Article)

    @Query("SELECT * FROM article")
    fun getArticles(): Flow<List<Article>>

}