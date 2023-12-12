package com.example.lunatiket.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/meta/getLanguages")
    fun getLanguages(): Call<List<PesawatItem>>
}