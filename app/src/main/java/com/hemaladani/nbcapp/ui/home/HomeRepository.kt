package com.hemaladani.nbcapp.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import com.hemaladani.nbcapp.data.Item

interface HomeRepository {
    fun getTrendingNowShelf(): LiveData<List<Item>?>
    fun getContinueWatchingShelf():LiveData<List<Item>?>
    fun getLatestEpisodesShelf():LiveData<List<Item>?>
}