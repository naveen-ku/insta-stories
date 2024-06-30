package com.example.instastories.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.instastories.data.db.dao.StoryDao
import com.example.instastories.data.db.dao.UserDao
import com.example.instastories.data.db.entity.Story
import com.example.instastories.data.db.entity.User

@Database(
    entities = [User::class, Story::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getStoryDao(): StoryDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "appDatabase")
                .build()
    }
}