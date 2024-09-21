package com.example.infoexpress.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(

    @ColumnInfo("title")
    val title: String,

    @ColumnInfo("description")
    val description: String,

    @ColumnInfo("urlToImage")
    val image: String,

    var isFavorite: Boolean = false,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    var id: Int = 0,
)

