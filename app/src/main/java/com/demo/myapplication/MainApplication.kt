package com.demo.myapplication

import android.app.Application

class MainApplication : Application() {

    companion object {
        @get:Synchronized
        var instance: MainApplication? = null
    }

    private fun init(app: MainApplication) {
        instance = app
    }

    override fun onCreate() {
        super.onCreate()
        init(this)
    }
}