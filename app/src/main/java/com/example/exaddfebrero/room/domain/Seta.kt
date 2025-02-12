package com.example.exaddfebrero.room.domain

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Setas",
    foreignKeys = [ForeignKey(
        entity = Album::class,
        parentColumns = ["id"],
        childColumns = ["albumId"],
        onDelete = ForeignKey.CASCADE
    )])
data class Seta(
    @PrimaryKey val id: Int,
    val name: String,
    val family: String,
    val description: String,
    val albumId: Int
)