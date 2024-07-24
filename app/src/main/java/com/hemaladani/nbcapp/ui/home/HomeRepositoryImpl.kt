package com.hemaladani.nbcapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hemaladani.nbcapp.data.Resource
import com.hemaladani.nbcapp.data.dto.home.Item
import com.hemaladani.nbcapp.data.dto.home.Shelf
import com.hemaladani.nbcapp.utils.Constants
import com.hemaladani.nbcapp.data.local.LocalData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class HomeRepositoryImpl @Inject constructor(
    private val localData: LocalData,
    private val ioDispatcher: CoroutineContext
) : HomeRepository {
    private fun getHomeShelves(): Resource<List<Shelf>> = localData.getHomePageShelves()

    override suspend fun fetchHomeShelves(): Flow<Resource<List<Shelf>>> {
        return flow {
            emit(localData.getHomePageShelves())
        }.flowOn(ioDispatcher)
    }
}

