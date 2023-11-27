package com.example.newsinshorts.data.datasource

import com.example.newsinshorts.data.api.ApiService
import com.example.newsinshorts.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {
    override suspend fun getTopHeadlines(country: String): Response<NewsResponse> {
        return apiService.getTopHeadlines(country)
    }
}