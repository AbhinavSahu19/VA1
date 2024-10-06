package com.example.va1.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.va1.mediator.BlogMediator
import com.example.va1.local.BlogDatabase
import com.example.va1.local.BlogRDC
import com.example.va1.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


//Not in use, TO DELETE
@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object PagerModule {
    @Provides
    @Singleton
    fun provideBeerPager(roomDatabase: BlogDatabase, apiService: ApiService): Pager<Int, BlogRDC> {
        return Pager(
            config = PagingConfig(pageSize = 1),
            remoteMediator = BlogMediator(
                apiService,
                roomDatabase
            ),
            pagingSourceFactory = {
                roomDatabase.dao.getAll()
            }
        )
    }
}