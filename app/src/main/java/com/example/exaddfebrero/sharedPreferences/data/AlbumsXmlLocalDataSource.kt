package com.example.exaddfebrero.sharedPreferences.data

import android.content.Context
import com.example.exaddfebrero.sharedPreferences.domain.Album
import com.example.exaddfebrero.sharedPreferences.domain.AlbumRepository
import com.example.exaddfebrero.sharedPreferences.domain.SetaRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AlbumsXmlLocalDataSource(private val context: Context): AlbumRepository {

    private val sharedPreferences = context.getSharedPreferences("Albumes", Context.MODE_PRIVATE)
    private val gson = Gson()
    private val type = object : TypeToken<List<Album>>() {}.type

    override fun saveAlbum(album: Album) {
        val albums = getAlbums().toMutableList()
        albums.add(album)
        saveAlbums(albums)
    }

    override fun getAlbums(): List<Album> {
        val json = sharedPreferences.getString("Lista de albumes", null) ?: return emptyList()
        return gson.fromJson(json, type)
    }

    override fun getAlbumId(id: String): Album? {
        return getAlbums().find { it.id == id }
    }

    override fun deleteAlbum(id: String) {
        val updateAlbums = getAlbums().filter { it.id != id }
        saveAlbums(updateAlbums)
    }

    private fun saveAlbums(albums: List<Album>) {
        val json = gson.toJson(albums)
        sharedPreferences.edit().putString("Lista de albumes", json).apply()
    }


}