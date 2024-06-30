package com.example.instastories.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.instastories.data.db.entity.Story
import com.example.instastories.data.db.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<User>)

    @Query("SELECT stories FROM users WHERE id = :userId")
    fun getUserStories(userId: String): List<Story>

}