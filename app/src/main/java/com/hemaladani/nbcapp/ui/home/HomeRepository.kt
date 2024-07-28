package com.hemaladani.nbcapp.ui.home

import com.hemaladani.nbcapp.data.Resource
import com.hemaladani.nbcapp.data.dto.home.Shelf
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun fetchHomeShelves(fileName:String): Flow<Resource<List<Shelf>>>
}