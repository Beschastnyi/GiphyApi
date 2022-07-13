package com.example.myapplication.mainactivity.api

import com.example.myapplication.mainactivity.data.GifDTO
import retrofit2.Response
import retrofit2.http.GET

interface GifApi {
    companion object {
        private const val API_KEY =
            "search?api_key=VC5M0TozSlVlqo7EaqS8XiucJBE4QB1C&q=1&limit=25&offset=0&rating=g&lang=en"
    }

    @GET(API_KEY)
    suspend fun getGifs(): Response<GifDTO>
}