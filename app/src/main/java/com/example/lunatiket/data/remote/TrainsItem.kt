package com.example.lunatiket.data.remote


import com.google.gson.annotations.SerializedName

data class TrainsItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("train_from")
    val trainFrom: String,
    @SerializedName("train_to")
    val trainTo: String
)