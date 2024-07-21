package com.lctproduction.monagement

import android.app.Application
import io.appwrite.BuildConfig
import timber.log.Timber

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree()) // Untuk log di mode debug
        }
    }
}