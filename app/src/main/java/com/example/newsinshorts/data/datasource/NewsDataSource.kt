package com.example.newsinshorts.data.datasource

import com.example.newsinshorts.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getTopHeadlines(country: String): Response<NewsResponse>
}