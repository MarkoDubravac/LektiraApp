package com.example.projektni_.model


import com.google.gson.annotations.SerializedName

data class LektirasItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("place")
    val place: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("characters")
    val characters: String,
    @SerializedName("plot")
    val plot: String
)

