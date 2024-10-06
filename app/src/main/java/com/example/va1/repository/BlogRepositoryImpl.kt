package com.example.va1.repository

import android.graphics.pdf.PdfDocument.Page
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.va1.local.BlogDatabase
import com.example.va1.local.BlogRDC
import com.example.va1.mediator.BlogMediator
import com.example.va1.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class BlogRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val roomDB: BlogDatabase
) : BlogRepository{

    override fun getAllBlogs(): Pager<Int, BlogRDC> = Pager(
        config = PagingConfig(pageSize = 20, enablePlaceholders = false),
        remoteMediator = BlogMediator(apiService, roomDB),
        pagingSourceFactory = { roomDB.dao.getAll() }
    )

    override suspend fun getById(id: Int): Flow<BlogRDC> = roomDB.dao.getById(id)
}