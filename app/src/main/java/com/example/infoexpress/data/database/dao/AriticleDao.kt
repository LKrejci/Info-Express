package com.example.infoexpress.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.infoexpress.data.database.entity.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: Article)

    @Delete
    fun deleteArticle(article: Article)

    @Query("SELECT * FROM article")
    fun getArticles(): Flow<List<Article>>

}