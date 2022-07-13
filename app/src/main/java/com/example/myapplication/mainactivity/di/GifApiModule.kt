package com.example.myapplication.mainactivity.di


import com.example.myapplication.mainactivity.api.GifApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class GifApiModule {

    @Provides
    fun provideSampleDataApi(retrofit: Retrofit): GifApi = retrofit.create(GifApi::class.java)
}