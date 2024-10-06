package com.example.va1.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import com.example.va1.local.BlogRDC
import kotlinx.coroutines.flow.Flow

interface BlogRepository {
    fun getAllBlogs(): Pager<Int, BlogRDC>

    suspend fun getById(id: Int): Flow<BlogRDC>
}