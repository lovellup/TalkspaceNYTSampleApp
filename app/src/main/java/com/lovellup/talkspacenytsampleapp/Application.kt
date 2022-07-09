package com.lovellup.talkspacenytsampleapp

import android.app.Application
import com.lovellup.talkspacenytsampleapp.di.appModule
import com.lovellup.talkspacenytsampleapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(networkModule, appModule)
        }
    }
}