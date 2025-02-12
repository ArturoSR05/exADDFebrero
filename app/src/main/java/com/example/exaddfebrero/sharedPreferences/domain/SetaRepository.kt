package com.example.exaddfebrero.sharedPreferences.domain

interface SetaRepository {

    fun addSeta(seta: Seta)
    fun getSetas(): List<Seta>
    fun saveSetas(seta: List<Seta>)
}