package com.hemaladani.nbcapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hemaladani.nbcapp.data.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class HomeViewModel @Inject constructor(private var homeRepository: HomeRepository) : ViewModel
(),HomeRepository {
    override fun getTrendingNowShelf(): LiveData<List<Item>?> = homeRepository.getTrendingNowShelf()
    override fun getContinueWatchingShelf(): LiveData<List<Item>?>  = homeRepository.getContinueWatchingShelf()
    override fun getLatestEpisodesShelf(): LiveData<List<Item>?> = homeRepository.getLatestEpisodesShelf()
}