package com.example.va1.network

import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://blog.vrid.in/wp-json/wp/v2/"

interface ApiService{
    @GET("posts")
    suspend fun getBlogs(
        @Query("per_page")perPage: Int = 10,
        @Query("page")pageNumber: Int
    ): List<BlogNDC>
}