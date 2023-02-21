/*
L’applicazione deve consentire di visualizzare in una activity i dati anagrafici di una persona
Nome
Cognome
Data di nascita
Città di Nascita
Provincia di Nascita
Sesso
E di inserirne di nuovi tramite un’altra activity
 */

package com.example.datianagrafici

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.datianagrafici.adapter.PersonaAdapter
import com.example.datianagrafici.dao.PersonaDatabase
import com.example.datianagrafici.servizi.PersonaServices
import java.time.LocalDate
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Impostazione del listener del pulsante "Aggiungi persona" per passare all'Activity di inserimento dei dati
        findViewById<Button>(R.id.aggiungi_nuova_persona).setOnClickListener {
            val intent = Intent(this, AddPeopleActivity::class.java)
            this.startActivity(intent)
        }


        val perServ = PersonaServices()

        // Inizializzazione del layout della RecyclerView
        findViewById<RecyclerView>(R.id.listanomi).apply {
            layoutManager = LinearLayoutManager(context)

        }

    }

    override fun onResume() {
        super.onResume()

        // Impostazione dell'adapter della RecyclerView e del database
        Executors.newSingleThreadExecutor().execute {
            findViewById<RecyclerView>(R.id.listanomi).adapter =
                Room.databaseBuilder(this, PersonaDatabase::class.java, "persona").build()
                    .let {
                        PersonaAdapter(it.getPersonaDao().getAll())

                    }


        }
    }


}

