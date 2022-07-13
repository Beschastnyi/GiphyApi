package com.example.myapplication.mainactivity.data

import com.google.gson.annotations.SerializedName

data class GifDTO(
    @SerializedName("data")
    val data: List<Data>
)