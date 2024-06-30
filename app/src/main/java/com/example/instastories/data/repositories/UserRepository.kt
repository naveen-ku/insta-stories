package com.example.instastories.data.repositories

import android.util.Log
import com.example.instastories.data.db.entity.User
import com.example.instastories.data.network.InstaApi

class UserRepository {

    suspend fun getUsers(): List<User> {
        val userData = InstaApi.retrofitService.getUsers()
        Log.d("Ninja", userData.toString());
        return userData.users;
    }

}