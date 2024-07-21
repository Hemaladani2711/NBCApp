package com.hemaladani.nbcapp.utils

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.hemaladani.nbcapp.data.Root
import com.hemaladani.nbcapp.data.Shelf
import okio.IOException
import java.io.InputStream

object HomeUtils{
    var shelveItems:List<Shelf>? = null
    lateinit var mContext: Context
    fun init(context: Context){
        mContext = context
    }
    fun getShelves():List<Shelf>?{
        try {
            val inputStream: InputStream = mContext.getAssets().open("homepage.json")
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