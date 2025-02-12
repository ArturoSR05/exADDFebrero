package com.example.exaddfebrero.sharedPreferences.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.exaddfebrero.sharedPreferences.data.AlbumsXmlLocalDataSource
import com.example.exaddfebrero.sharedPreferences.domain.Album
import com.example.exaddfebrero.sharedPreferences.domain.AlbumRepository
import com.example.exaddfebrero.sharedPreferences.domain.Seta

class AlbumsActivity: AppCompatActivity() {

    private lateinit var repository: AlbumRepository

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        repository = AlbumsXmlLocalDataSource(this)

        val album = Album(
            id = "1",
            name = "Setas de Ávila",
            setas = listOf(
                Seta("1", "Boletus", "Boletacea", "Se puede comer"),
                Seta("2", "Amanita Cesarea", "Amanita", "Grande"),
                Seta("3", "Agaricus Campestris", "Agaritus", "Muy singular")
            ),
        )

        repository.saveAlbum(album)

        val albums = repository.getAlbums()
        Log.d("Albumes", albums.toString())

        repository.deleteAlbum(album.id)
    }
}