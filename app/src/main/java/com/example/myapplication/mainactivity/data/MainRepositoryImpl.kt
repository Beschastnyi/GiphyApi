package com.example.myapplication.mainactivity.data

import com.example.myapplication.mainactivity.api.GifApi
import com.example.myapplication.mainactivity.domain.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val api: GifApi) : MainRepository {
    override suspend fun getGifs() = api.getGifs()
}