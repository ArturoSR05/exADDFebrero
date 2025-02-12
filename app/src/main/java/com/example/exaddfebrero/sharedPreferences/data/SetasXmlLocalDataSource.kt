package com.example.exaddfebrero.sharedPreferences.data

import android.content.Context
import com.example.exaddfebrero.sharedPreferences.domain.Seta
import com.example.exaddfebrero.sharedPreferences.domain.SetaRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SetasXmlLocalDataSource(private val context: Context): SetaRepository {

    private val sharedPreferences = context.getSharedPreferences("Setas", Context.MODE_PRIVATE)

    private val gson = Gson()

    override fun addSeta(seta: Seta) {
        val currentList = getSetas().toMutableList()
        currentList.add(seta)
        saveSetas(currentList)
    }

    override fun getSetas(): List<Seta> {
        val json = sharedPreferences.getString("Listado de setas", null) ?: return emptyList()
        val type = object : TypeToken<List<Seta>>() {}.type
        return gson.fromJson(json, type)
    }

    override fun saveSetas(seta: List<Seta>) {
        val json = gson.toJson(seta)
        sharedPreferences.edit().putString("Listado de setas", json).apply()
    }
}