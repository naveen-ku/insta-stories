package com.example.instastories.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "story")
data class Story(
    @PrimaryKey val id: String,
    val userId: String,
    val imageUrl: String,
    val createdAt : String,
    val seen: Boolean
)