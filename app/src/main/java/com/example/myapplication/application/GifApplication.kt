package com.example.myapplication.application

import android.app.Application
import com.example.myapplication.application.di.ApplicationComponent
import com.example.myapplication.application.di.ApplicationModule
import com.example.myapplication.application.di.DaggerApplicationComponent

class GifApplication : Application() {
    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        component = DaggerApplicationComponent.builder().build()
    }
}