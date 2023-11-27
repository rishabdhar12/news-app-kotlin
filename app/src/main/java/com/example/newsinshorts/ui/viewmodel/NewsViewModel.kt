package com.example.newsinshorts.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsinshorts.data.entity.NewsResponse
import com.example.newsinshorts.ui.repository.NewsRepository
import com.example.utilities.ApiConstants
import com.example.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel(){

    private val _news: MutableStateFlow<ResourceState<NewsResponse>> = MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<NewsResponse>> = _news

    init {
        getNews(ApiConstants.COUNTRY)
    }
    private fun getNews(country: String) {
        viewModelScope.launch (Dispatchers.IO){
            newsRepository.getNewsHeadline(country).collectLatest {newsResponse ->
                _news.value = newsResponse
            }
        }
    }
    init {
        Log.d(TAG, "Init NewsViewModel")
    }

    companion object {
        const val TAG = "NewsViewModel"
    }
}