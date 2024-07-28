package com.hemaladani.nbcapp.home

import android.content.Context
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.platform.app.InstrumentationRegistry
import com.hemaladani.nbcapp.data.dto.home.Shelf
import com.hemaladani.nbcapp.data.local.LocalData
import com.hemaladani.nbcapp.ui.home.HomeRepositoryImpl
import com.hemaladani.nbcapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.toList
import org.junit.Before
import org.junit.Test
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import java.util.Objects


class HomeRepositoryImplTest {
    val fileName = Constants.fileName
    lateinit var context: Context
    lateinit var localData: LocalData
    lateinit var homeRepositoryImpl: HomeRepositoryImpl

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        localData = LocalData(context)
        homeRepositoryImpl = HomeRepositoryImpl(localData,Dispatchers.IO)
    }

    @Test
    fun fetchHomeShelves_whenDataRetrieveSuccessfully(): Unit = runTest{
        homeRepositoryImpl.fetchHomeShelves(fileName).collect { resource ->
            assertEquals(true,Objects.nonNull(resource.data))
            assertEquals(true,Objects.isNull(resource.errorMessage))
        }
    }

}