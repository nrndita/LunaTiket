package com.example.lunatiket.data.remote


import com.google.gson.annotations.SerializedName

data class TrainReq(
    @SerializedName("search")
    val name: String
)