package com.hemaladani.nbcapp.ui.home


import com.hemaladani.nbcapp.data.Resource
import com.hemaladani.nbcapp.data.dto.home.Shelf
import com.hemaladani.nbcapp.data.local.LocalData
import com.hemaladani.nbcapp.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class HomeRepositoryImpl @Inject constructor(
    private val localData: LocalData,
    private val ioDispatcher: CoroutineContext
) : HomeRepository {

    override suspend fun fetchHomeShelves(fileName:String): Flow<Resource<List<Shelf>>> {
        return flow {
            emit(localData.getHomePageShelves(fileName))
        }.flowOn(ioDispatcher)
    }
}

