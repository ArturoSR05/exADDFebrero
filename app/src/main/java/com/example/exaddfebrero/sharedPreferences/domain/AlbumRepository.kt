package com.example.exaddfebrero.sharedPreferences.domain

interface AlbumRepository {
    fun saveAlbum(album: Album)
    fun getAlbums(): List<Album>
    fun getAlbumId(id: String): Album?
    fun deleteAlbum(id: String)
}