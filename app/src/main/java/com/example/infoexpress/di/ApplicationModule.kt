package com.example.infoexpress.di

import android.content.Context
import androidx.room.Room
import com.example.infoexpress.data.database.ArticleDatabase
import com.example.infoexpress.data.database.dao.ArticleDao
import com.example.infoexpress.data.database.local.LocalDataSource
import com.example.infoexpress.data.database.remote.RemoteDataSource
import com.example.infoexpress.data.database.repository.Repository
import com.example.infoexpress.data.database.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

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

    @Provides
    @Singleton
    fun provideRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): Repository = RepositoryImpl(localDataSource, remoteDataSource)
}