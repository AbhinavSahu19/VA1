package com.example.va1.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blog_table")
data class BlogRDC(
    @PrimaryKey
    val id: Int,
    val date: String,
    val title: String,
    val content: String
)
