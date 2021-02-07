package com.example.spotifycloneapp.data.Remote

import com.example.spotifycloneapp.data.Remote.model.RadiosResponse
import io.reactivex.Single
import retrofit2.http.GET

interface SpotifyApiService {
    @GET("popularRadios.json")
    fun getPopularRadios(): Single<List<RadiosResponse>>

    @GET("locationRadios.json")
    fun getLocationRadios(): Single<List<RadiosResponse>>
}