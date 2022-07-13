package com.example.myapplication.application.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ApplicationModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = app
}