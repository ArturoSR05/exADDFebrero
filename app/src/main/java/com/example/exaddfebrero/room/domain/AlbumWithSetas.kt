package com.example.exaddfebrero.room.domain

import androidx.room.Embedded
import androidx.room.Relation

data class AlbumWithSetas(
    @Embedded val album: Album,
    @Relation(
        parentColumn = "id",
        entityColumn = "albumId"
    )
    val setas: List<Seta>
)