package com.example.myapplication.application.di

import com.example.myapplication.mainactivity.api.GifApi
import com.example.myapplication.mainactivity.di.GifApiModule
import com.example.myapplication.mainactivity.domain.MainRepository
import com.example.myapplication.mainactivity.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class, RepositoryModule::class, GifApiModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun provideApi(api: GifApi)
}