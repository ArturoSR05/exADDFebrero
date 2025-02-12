package com.example.exaddfebrero.room.data

import com.example.exaddfebrero.room.domain.Album
import com.example.exaddfebrero.room.domain.AlbumWithSetas
import com.example.exaddfebrero.room.domain.Seta

class AlbumDataRepository(
    private val albumDao: AlbumDao,
    private val setaDao: SetaDao) {

    suspend fun getAlbums(): List<com.example.exaddfebrero.sharedPreferences.domain.Album> {
        return albumDao.getAlbums()
    }

    suspend fun getAlbumWithSetas(albumId: Int): AlbumWithSetas? {
        return albumDao.getAlbumWithSetas(albumId)
    }

    suspend fun deleteAlbum(album: Album) {
        albumDao.deleteAlbum(album)
    }

    suspend fun deleteSeta(seta: Seta) {
        setaDao.deleteSeta(seta)
    }
}