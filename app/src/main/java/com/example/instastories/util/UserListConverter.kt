package com.example.instastories.util

import com.example.instastories.data.db.entity.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserListConverter {
    companion object {
        /** Convert User Model List to String */
        fun fromStoryList(users: List<User>): String {
            val gson = Gson()
            val type = object : TypeToken<List<User>>() {}.type
            return gson.toJson(users, type)
        }

        /** Convert User data string to List of User Model*/
        fun toStoryList(userString: String): List<User> {
            val gson = Gson()
            val type = object : TypeToken<List<User>>() {}.type
            return gson.fromJson(userString, type)
        }

        /** Convert User model to string */
        fun fromStory(user: User): String {
            val gson = Gson()
            val type = object : TypeToken<User>() {}.type
            return gson.toJson(user, type)
        }

        /** Convert User string data to User Model */
        fun toStory(userString: String): User {
            val gson = Gson()
            val type = object : TypeToken<User>() {}.type
            return gson.fromJson(userString, type)
        }
    }

}
