package com.example.instastories.data.network

import com.example.instastories.data.db.entity.User
import retrofit2.http.GET

interface InstaApiService {
    @GET("api/getUsers")
    suspend fun getUsers(): List<User>
}