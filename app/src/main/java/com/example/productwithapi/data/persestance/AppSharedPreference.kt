package com.example.productwithapi.data.persestance

import android.content.Context
import com.example.productwithapi.persentation.App

class AppSharedPreference {
    val sharedPref = App.context
        .getSharedPreferences(
            "sharedPreference", Context.MODE_PRIVATE
        )

    fun saveToken(token: String) {
        with(sharedPref.edit()) {
            putString("token", token).apply()
        }
    }

    fun getToken():String? {
       return sharedPref.getString("token",null)
    }
}