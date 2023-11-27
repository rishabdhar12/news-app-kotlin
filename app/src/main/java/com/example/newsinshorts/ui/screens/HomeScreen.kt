package com.example.newsinshorts.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsinshorts.ui.components.Loader
import com.example.newsinshorts.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

const val TAG = "HOME-SCREEN"
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val newsResponse by newsViewModel.news.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        when(newsResponse) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside Loading")
                Loader()
            }

            is ResourceState.Success -> {
                Log.d(TAG, "Inside Success")
            }

            is ResourceState.Error -> {
                Log.d(TAG, "Inside Error")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}