package com.hemaladani.nbcapp.data.local

import android.content.Context
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import com.google.gson.Gson
import com.hemaladani.nbcapp.data.Resource
import com.hemaladani.nbcapp.data.dto.home.Root
import com.hemaladani.nbcapp.data.dto.home.Shelf
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class LocalData @Inject constructor(val context: Context){

    fun getHomePageShelves(filename:String):Resource<List<Shelf>>{
        try {
            val context = ApplicationProvider.getApplicationContext<Context>()
            val inputStream: InputStream = context.getAssets().open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, charset("UTF-8"))
            val root = Gson().fromJson(json, Root::class.java)
            return Resource.Success(root.shelves)
        }catch (e: IOException){
            Log.e("JSON Parse Error",e.toString())
            return Resource.DataError(e.toString())
        }

    }


}