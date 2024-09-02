package com.example.infoexpress.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.infoexpress.data.database.entity.Article

@Dao
interface ArticleDao {

    @Upsert
    fun insertArticle(article: Article)

    @Delete
    fun deleteArticle(article: Article)

    @Query("SELECT * FROM article")
    fun getArticles(): List<Article>

}