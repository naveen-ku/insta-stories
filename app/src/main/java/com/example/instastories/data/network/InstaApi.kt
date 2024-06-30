package com.example.instastories.data.network

import com.example.instastories.data.db.entity.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface InstaApi {
    @GET("api/getUsers")
    suspend fun getUsers(): List<User>
    companion object {
        operator fun invoke(): InstaApi {
            return Retrofit.Builder()
                .baseUrl("https://us-central1-insta-stories-firebase.cloudfunctions.net/app/")
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(InstaApi::class.java)
        }

    }

}

interface InstaApiService {


}