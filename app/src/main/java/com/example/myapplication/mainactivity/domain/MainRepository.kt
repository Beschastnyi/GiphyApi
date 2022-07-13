package com.example.myapplication.mainactivity.domain

import com.example.myapplication.mainactivity.data.GifDTO
import retrofit2.Response

interface MainRepository {
    suspend fun getGifs(): Response<GifDTO>
}