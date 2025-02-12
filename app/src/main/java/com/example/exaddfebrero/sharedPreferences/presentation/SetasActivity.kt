package com.example.exaddfebrero.sharedPreferences.presentation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exaddfebrero.sharedPreferences.data.SetasXmlLocalDataSource
import com.example.exaddfebrero.sharedPreferences.domain.Seta
import com.example.exaddfebrero.sharedPreferences.domain.SetaRepository

class SetasActivity: AppCompatActivity() {

    private lateinit var repository: SetaRepository

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        repository = SetasXmlLocalDataSource(this)

        val seta = Seta(
            id = "1",
            name = "Boletus",
            family = "Boletacea",
            description = "Se puede comer"
        )

        repository.addSeta(seta)
    }
}