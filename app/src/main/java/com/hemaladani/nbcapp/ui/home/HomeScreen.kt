package com.hemaladani.nbcapp.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.hemaladani.nbcapp.R
import com.hemaladani.nbcapp.data.dto.home.Shelf

@Composable
fun TrendingNowViewSetUp(homeViewModel: HomeViewModel) {
    LaunchedEffect(key1 = Unit) {
        homeViewModel.getTrendingNowShelf()
        homeViewModel.getLatestEpisodesShelf()
        homeViewModel.getContinueWatchingShelf()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            val trendingNowResource by homeViewModel.trendingNowShelfLivedata.observeAsState(com.hemaladani.nbcapp.data.Resource.Loading())
            val latestEpisodesResource by homeViewModel.latestEpisodesShelfLivedata.observeAsState(com.hemaladani.nbcapp.data.Resource.Loading())
            val continueWatchingResource by homeViewModel.continueWatchingShelfLivedata.observeAsState(com.hemaladani.nbcapp.data.Resource.Loading())
            trendingNowResource?.data?.let {
                val trendingNowShelf = remember { it }
                PopulateShelves(trendingNowShelf)
            }
            latestEpisodesResource?.data?.let {
                val latestEpisodesShelf = remember { it }
                PopulateShelves(latestEpisodesShelf)
            }

            continueWatchingResource?.data?.let {
                val continueWatchingShelf = remember { it }
                PopulateShelves(continueWatchingShelf)
            }
        }

    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PopulateShelves(shelf: Shelf) {
    //TODO:Improve UI
    Column {
        Text(text = shelf.title, color = Color.White)
        LazyRow {
            items(shelf.items) { show ->
                Column {
                    show?.image?.let {
                        GlideImage(
                            model = it,
                            contentDescription = stringResource(id = R.string.show_image_description)
                        )
                    }
                    show?.title?.let {
                        Text(text = it, color = Color.White)
                    }

                }
            }
        }
    }
}