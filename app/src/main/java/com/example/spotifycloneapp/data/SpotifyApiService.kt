package com.example.spotifycloneapp.data

import com.example.spotifycloneapp.data.model.RadiosResponse
import retrofit2.Call
import retrofit2.http.GET

interface SpotifyApiService {
    @GET("popularRadios.json")
    fun getPopularRadios(): Call<List<RadiosResponse>>

    @GET("locationRadios.json")
    fun getLocationRadios(): Call<List<RadiosResponse>>
}