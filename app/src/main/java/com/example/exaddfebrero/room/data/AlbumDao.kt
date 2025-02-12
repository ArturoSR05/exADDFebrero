package com.example.exaddfebrero.room.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.exaddfebrero.room.domain.AlbumWithSetas
import com.example.exaddfebrero.sharedPreferences.domain.Album

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbum(album: com.example.exaddfebrero.room.domain.Album): Long

    @Query("SELECT * FROM albumes")
    suspend fun getAlbums(): List<Album>

    @Transaction
    @Query("SELECT * FROM albumes WHERE id = :albumId")
    suspend fun getAlbumWithSetas(albumId: Int): AlbumWithSetas?

    @Delete
    suspend fun deleteAlbum(album: com.example.exaddfebrero.room.domain.Album)
}