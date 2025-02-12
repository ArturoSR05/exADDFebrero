package com.example.exaddfebrero.room.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.exaddfebrero.room.AppDataBase
import com.example.exaddfebrero.room.data.AlbumDao
import com.example.exaddfebrero.room.data.SetaDao
import com.example.exaddfebrero.room.domain.Album
import com.example.exaddfebrero.room.domain.Seta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomActivity: AppCompatActivity() {

    private lateinit var db: AppDataBase
    private lateinit var albumDao: AlbumDao
    private lateinit var setaDao: SetaDao

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        db = AppDataBase.getDataBase(this)
        albumDao = db.albumDao()
        setaDao = db.setaDao()

        CoroutineScope(Dispatchers.IO).launch {
            val album = Album("15", "Setas Gredos")
            val albumId = albumDao.insertAlbum(album).toInt()

            val seta1 = Seta(
                id = 12,
                name = "Boletus",
                family = "Boletus",
                description = "Se puede comer",
                albumId = 15
            )

            val seta2 = Seta(
                id = 11,
                name = "Amanita Cesarea",
                family = "Amanita",
                description = "Peculiar",
                albumId = 15
            )

            setaDao.insertSeta(seta1)
            setaDao.insertSeta(seta2)

            val albums = albumDao.getAlbums()
            albums.forEach { album ->
                val albumWithSetas = albumDao.getAlbumWithSetas(albumId)
                Log.d("Album", "Nombre: ${album.name}, Setas: ${albumWithSetas?.setas}")
            }
        }
    }
}