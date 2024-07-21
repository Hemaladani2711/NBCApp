package com.hemaladani.nbcapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hemaladani.nbcapp.data.Item
import com.hemaladani.nbcapp.data.Shelf
import com.hemaladani.nbcapp.utils.Constants
import com.hemaladani.nbcapp.utils.HomeUtils

object HomeRepositoryImpl:HomeRepository {
    private fun getHomeShelves():List<Shelf>? = HomeUtils.getShelves()

    override fun getTrendingNowShelf():LiveData<List<Item>?>{
        var itemsLiveData = MutableLiveData<List<Item>?>()
        var items:List<Item>? = null
        getHomeShelves()?.let{shelves->
            for (shelf in shelves){
                if(shelf.title.contentEquals(Constants.trendingNow)){
                    items = shelf.items
                }
            }
        }
        items?.let {
            itemsLiveData.value = items
        }

        return itemsLiveData
    }

    override fun getLatestEpisodesShelf():LiveData<List<Item>?>{
        var itemsLiveData = MutableLiveData<List<Item>?>()
        var items:List<Item>? = null
        getHomeShelves()?.let{shelves->
            for (shelf in shelves){
                if(shelf.title.contentEquals(Constants.latestEpisodes)){
                    items = shelf.items
                }
            }
        }
        items?.let {
            itemsLiveData.value = items
        }

        return itemsLiveData
    }

    override fun getContinueWatchingShelf():LiveData<List<Item>?>{
        var itemsLiveData = MutableLiveData<List<Item>?>()
        var items:List<Item>? = null
        getHomeShelves()?.let{shelves->
            for (shelf in shelves){
                if(shelf.title.contentEquals(Constants.continueWatching)){
                    items = shelf.items
                }
            }
        }
        items?.let {
            itemsLiveData.value = items
        }

        return itemsLiveData
    }

}