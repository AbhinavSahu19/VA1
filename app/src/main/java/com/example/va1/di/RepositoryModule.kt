package com.example.va1.di

import com.example.va1.repository.BlogRepository
import com.example.va1.repository.BlogRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideBlogRepo(repo: BlogRepositoryImpl): BlogRepository
}