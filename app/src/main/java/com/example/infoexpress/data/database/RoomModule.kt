package com.example.infoexpress.data.database

import android.content.Context
import androidx.room.Room
import com.example.infoexpress.data.database.dao.ArticleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): ArticleDatabase {
        return Room.databaseBuilder(context, ArticleDatabase::class.java, "article-database").build()
    }


    @Provides
    @Singleton
    fun provideArticleDao(articleDatabase: ArticleDatabase): ArticleDao {
        return articleDatabase.articleDao
    }
}