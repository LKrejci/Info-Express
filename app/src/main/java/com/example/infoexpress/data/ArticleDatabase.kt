package com.example.infoexpress.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.infoexpress.data.dao.ArticleDao
import com.example.infoexpress.data.entity.Article

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)
abstract class ArticleDatabase: RoomDatabase() {

    abstract val articleDao: ArticleDao

}