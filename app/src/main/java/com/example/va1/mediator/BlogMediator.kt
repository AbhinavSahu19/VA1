package com.example.va1.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.va1.local.BlogDatabase
import com.example.va1.local.BlogRDC
import com.example.va1.models.toBlogRDC
import com.example.va1.network.ApiService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class BlogMediator @Inject constructor(
    private val apiService: ApiService,
    private val blogDB: BlogDatabase
) : RemoteMediator<Int, BlogRDC>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BlogRDC>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    lastItem?.id?.let { (it / state.config.pageSize) + 1 }
                        ?: return MediatorResult.Success(endOfPaginationReached = true)
                }
            }

            val page = loadKey ?: 1
            val blogs = apiService.getBlogs(
                pageNumber = page,
                perPage = state.config.pageSize
            )

            blogDB.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    blogDB.dao.clearAll()
                }
                val blogsDC = blogs.map { it.toBlogRDC() }
                blogDB.dao.upsertAll(blogsDC)
            }

            MediatorResult.Success(endOfPaginationReached = blogs.isEmpty())
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

}