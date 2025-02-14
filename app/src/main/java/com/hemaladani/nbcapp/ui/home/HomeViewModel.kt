package com.hemaladani.nbcapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemaladani.nbcapp.data.Resource
import com.hemaladani.nbcapp.data.dto.home.Item
import com.hemaladani.nbcapp.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private var homeRepository: HomeRepository) : ViewModel
(){
    private val fileName:String = "homepage_tests.json"
    val trendingNowShelfLivedata = MutableLiveData<Resource<List<Item>>>()
    val continueWatchingShelfLivedata = MutableLiveData<Resource<List<Item>>>()
    val latestEpisodesShelfLivedata = MutableLiveData<Resource<List<Item>>>()
    fun getTrendingNowShelf(){
        viewModelScope.launch {
            homeRepository.fetchHomeShelves(fileName).collect{shelves->
                when(shelves){
                    is Resource.DataError -> trendingNowShelfLivedata.value = Resource
                        .DataError(shelves.errorMessage!!)
                    is Resource.Loading -> trendingNowShelfLivedata.value = Resource.Loading()
                    is Resource.Success -> {
                        shelves.data?.let {
                            for(items in it){
                                if(items.title.contentEquals(Constants.trendingNow)){
                                    trendingNowShelfLivedata.value = Resource.Success(items.items)
                                }
                            }

                        }
                    }
                }

            }
        }
    }

    fun getContinueWatchingShelf() {
        viewModelScope.launch {
            continueWatchingShelfLivedata.value = Resource.Loading()
            homeRepository.fetchHomeShelves(fileName).collect{shelves->
                when(shelves){
                    is Resource.DataError -> continueWatchingShelfLivedata.value = Resource
                        .DataError(shelves.errorMessage!!)
                    is Resource.Loading -> continueWatchingShelfLivedata.value = Resource.Loading()
                    is Resource.Success -> {
                        shelves.data?.let {
                            for(items in it){
                                if(items.title.contentEquals(Constants.continueWatching)){
                                    continueWatchingShelfLivedata.value = Resource.Success(items.items)
                                }
                            }

                        }
                    }
                }

            }
        }


    }
    fun getLatestEpisodesShelf(){
        viewModelScope.launch {
            latestEpisodesShelfLivedata.value = Resource.Loading()
            homeRepository.fetchHomeShelves(fileName).collect{shelves->
                when(shelves){
                    is Resource.DataError -> latestEpisodesShelfLivedata.value = Resource
                        .DataError(shelves.errorMessage!!)
                    is Resource.Loading -> latestEpisodesShelfLivedata.value = Resource.Loading()
                    is Resource.Success -> {
                        shelves.data?.let {
                            for(items in it){
                                if(items.title.contentEquals(Constants.latestEpisodes)){
                                    latestEpisodesShelfLivedata.value = Resource.Success(items.items)
                                }
                            }

                        }
                    }
                }

            }
        }
    }
}