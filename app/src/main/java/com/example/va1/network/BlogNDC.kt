package com.example.va1.network

import com.google.gson.annotations.SerializedName

data class BlogNDC(
    @SerializedName("id")
    val id: Int,
    @SerializedName("date")
    val date: String,
    @SerializedName("title")
    val title: RenderedNDC,
    @SerializedName("content")
    val content: RenderedNDC
)

data class RenderedNDC (
    @SerializedName("rendered")
    val rendered: String
)
