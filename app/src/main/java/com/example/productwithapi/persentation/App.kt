package com.example.productwithapi.persentation

import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}