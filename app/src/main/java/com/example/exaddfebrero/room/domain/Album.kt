package com.example.exaddfebrero.room.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.exaddfebrero.sharedPreferences.domain.Seta

@Entity(tableName = "Albumes")
data class Album (
    @PrimaryKey val id: String,
    val name: String
)