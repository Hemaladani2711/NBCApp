package com.hemaladani.nbcapp.utils

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.hemaladani.nbcapp.data.Root
import com.hemaladani.nbcapp.data.Shelf
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class HomeUtils @Inject constructor(val context: Context){
    var shelveItems:List<Shelf>? = null

    fun getShelves():List<Shelf>?{
        try {
            val inputStream: InputStream = context.getAssets().open("homepage.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, charset("UTF-8"))
            val root = Gson().fromJson(json,Root::class.java)
            shelveItems = root.shelves
        }catch (e: IOException){
            Log.e("JSON Parse Error",e.toString())
        }
        return shelveItems
    }


}