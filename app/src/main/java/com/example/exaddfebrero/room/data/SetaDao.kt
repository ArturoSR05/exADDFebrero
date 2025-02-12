package com.example.exaddfebrero.room.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.exaddfebrero.room.domain.Seta

@Dao
interface SetaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeta(seta: Seta)

    @Query("SELECT * FROM setas")
    suspend fun getSetas(): List<Seta>

    @Query("SELECT * FROM setas WHERE albumId = :albumId")
    suspend fun getSetasByAlbum(albumId: Int): List<Seta>

    @Delete
    suspend fun deleteSeta(seta: Seta)
}