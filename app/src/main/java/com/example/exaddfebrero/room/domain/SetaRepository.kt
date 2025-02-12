package com.example.exaddfebrero.room.domain

import com.example.exaddfebrero.room.data.SetaDao

class SetaRepository(private val setaDao: SetaDao) {

    suspend fun getSetas(): List<Seta> {
        return setaDao.getSetas()
    }

    suspend fun deleteSeta(seta: Seta) {
        setaDao.deleteSeta(seta)
    }
}