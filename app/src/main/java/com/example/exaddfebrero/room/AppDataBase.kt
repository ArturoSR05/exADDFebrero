package com.example.exaddfebrero.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exaddfebrero.room.data.AlbumDao
import com.example.exaddfebrero.room.data.SetaDao
import com.example.exaddfebrero.room.domain.Seta

@Database(entities = [Seta::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun setaDao(): SetaDao
    abstract fun albumDao(): AlbumDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "album_base_de_datos"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}