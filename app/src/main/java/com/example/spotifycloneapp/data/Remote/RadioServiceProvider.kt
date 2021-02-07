package com.example.spotifycloneapp.data.Remote

import com.example.spotifycloneapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RadioServiceProvider {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BuildConfig.SERVER_URL)
        .build()

    private val apiService = retrofit.create(SpotifyApiService::class.java)

    fun getRadioService(): SpotifyApiService = apiService

}