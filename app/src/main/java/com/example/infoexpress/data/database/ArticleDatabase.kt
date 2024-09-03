package com.example.infoexpress.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.infoexpress.data.database.dao.ArticleDao
import com.example.infoexpress.data.database.entity.Article

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)
abstract class ArticleDatabase: RoomDatabase() {

    abstract val articleDao: ArticleDao

}