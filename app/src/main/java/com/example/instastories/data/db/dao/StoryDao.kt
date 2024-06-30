package com.example.instastories.data.db.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface StoryDao {
    @Query("UPDATE story SET seen = :seen WHERE id = :storyId")
    fun updateStorySeenStatus(storyId: String, seen: Boolean)
}