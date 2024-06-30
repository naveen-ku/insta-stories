package com.example.instastories.data.repositories

import android.util.Log
import com.example.instastories.data.db.entity.User
import com.example.instastories.data.network.InstaApi

class UserRepository {

    suspend fun getUsers(): List<User> {
        val users = InstaApi().getUsers();
        Log.d("Ninja", users.toString());
        return users;
    }

}