package com.example.instastories.data.repositories

import android.content.Context
import android.util.Log
import com.example.instastories.data.db.entity.User
import com.example.instastories.data.network.InstaApiService
import com.example.instastories.data.network.RetrofitClient
import retrofit2.Retrofit
import retrofit2.create

class UserRepository(private val context: Context) {

    suspend fun getUsers(): List<User> {
        val retrofit = RetrofitClient.getClient(context)
        val instaApiService = retrofit.create(InstaApiService::class.java)
        val userData = instaApiService.getUsers()
        Log.d("Ninja", "UserRepository getUsers()")
        return userData;
    }

}