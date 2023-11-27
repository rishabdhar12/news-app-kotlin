package com.example.newsinshorts.data.api

import com.example.newsinshorts.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apKey: String = "ff7543b5f4e543438ac0536d92bf7903",
    ): Response<NewsResponse>
}