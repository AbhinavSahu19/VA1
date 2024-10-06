package com.example.va1.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface BlogDao{
    @Upsert
    suspend fun upsertAll(beers: List<BlogRDC>)

    @Query("SELECT * FROM blog_table")
    fun getAll(): PagingSource<Int, BlogRDC>

    @Query("SELECT * FROM blog_table where id = :id")
    fun getById(id: Int): Flow<BlogRDC>

    @Query("DELETE FROM blog_table")
    suspend fun clearAll()
}