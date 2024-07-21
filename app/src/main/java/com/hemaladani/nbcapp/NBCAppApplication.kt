package com.hemaladani.nbcapp

import android.app.Application
import com.hemaladani.nbcapp.utils.HomeUtils

class NBCAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        HomeUtils.init(this)
    }
}