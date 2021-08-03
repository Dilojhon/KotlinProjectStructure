package com.example.kotlinprojectstructure.base

import android.app.Application
import com.example.kotlinprojectstructure.utils.MyApplicationPreferences


class MyApplication : Application() {
    companion object {
        lateinit var appContext: Application
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        MyApplicationPreferences.init(applicationContext)
    }
}