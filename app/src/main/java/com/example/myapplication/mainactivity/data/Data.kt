package com.example.myapplication.mainactivity.data

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("images")
    val images: DataImage
)

data class DataImage(
    @SerializedName("original")
    val urlAddress: UrlAddress
)

data class UrlAddress(
    @SerializedName("url")
    val url: String
)