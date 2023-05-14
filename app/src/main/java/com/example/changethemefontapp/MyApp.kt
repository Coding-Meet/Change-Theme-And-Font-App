package com.example.changethemefontapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        val sharedPreferenceManger = SharedPreferenceManger(this)
        AppCompatDelegate.setDefaultNightMode(sharedPreferenceManger.themeFlag[sharedPreferenceManger.theme])
    }
}