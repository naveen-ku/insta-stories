package com.example.instastories.util


import com.example.instastories.data.db.entity.Story
import com.example.instastories.data.db.entity.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserListConverter {

    companion object {


        fun fromStoryList(users: List<User>): String {
            val gson = Gson()
            val type = object : TypeToken<List<Story>>() {}.type
            return gson.toJson(users, type)
        }

        fun toStoryList(userString: String): List<User> {
            val gson = Gson()
            val type = object : TypeToken<List<User>>() {}.type
            return gson.fromJson(userString, type)
        }
    }

}
