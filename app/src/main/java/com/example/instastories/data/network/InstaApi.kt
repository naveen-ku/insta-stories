package com.example.instastories.data.network

import com.example.instastories.data.db.entity.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl("https://us-central1-insta-stories-firebase.cloudfunctions.net/app/")
    .addConverterFactory(GsonConverterFactory.create()).build()

object InstaApi {
    val retrofitService : InstaApiService by lazy {
        retrofit.create(InstaApiService::class.java)
    }
}