package com.hemaladani.nbcapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hemaladani.nbcapp.data.Item

class HomeViewModel : ViewModel(),HomeRepository {
    override fun getTrendingNowShelf(): LiveData<List<Item>?> = HomeRepositoryImpl
        .getTrendingNowShelf()
    override fun getContinueWatchingShelf(): LiveData<List<Item>?>  = HomeRepositoryImpl.getContinueWatchingShelf()
    override fun getLatestEpisodesShelf(): LiveData<List<Item>?> = HomeRepositoryImpl.getLatestEpisodesShelf()
}