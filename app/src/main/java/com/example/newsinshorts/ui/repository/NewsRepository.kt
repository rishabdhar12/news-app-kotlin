package com.example.newsinshorts.ui.repository

import com.example.newsinshorts.data.datasource.NewsDataSource
import com.example.newsinshorts.data.entity.NewsResponse
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {
    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())
            val response = newsDataSource.getTopHeadlines(country)
            if(response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching news"))
            }
        }.catch { e ->  emit(ResourceState.Error(e.localizedMessage?:"Some error in flow"))}
    }
}