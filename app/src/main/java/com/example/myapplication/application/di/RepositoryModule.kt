package com.example.myapplication.application.di

import com.example.myapplication.mainactivity.api.GifApi
import com.example.myapplication.mainactivity.domain.MainRepository
import com.example.myapplication.mainactivity.data.MainRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesUserRepository(api: GifApi): MainRepository {
        return MainRepositoryImpl(api)
    }
}