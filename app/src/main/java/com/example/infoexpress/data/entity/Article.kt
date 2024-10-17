package com.example.infoexpress.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(

    @ColumnInfo("title")
    var title: String,

    @ColumnInfo("description")
    var description: String,

    @ColumnInfo("urlToImage")
    val image: String,

    var isFavorite: Boolean = false,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    var id: Int = 0,
)

