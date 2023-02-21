package com.example.datianagrafici

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.room.Room
import com.example.datianagrafici.dao.PersonaDatabase
import com.example.datianagrafici.entity.Gender
import com.example.datianagrafici.entity.Persona
import com.example.datianagrafici.servizi.PersonaServices
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AddPeopleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_people)

        val perServ = PersonaServices()
        val button: Button = findViewById(R.id.aggiungi_nuova_persona)
        button.setOnClickListener {

            val editName: EditText = findViewById(R.id.edit_name)
            val editSurname: EditText = findViewById(R.id.edit_surname)
            val editDate: EditText = findViewById(R.id.edit_birthday)
            val genderMale: RadioButton = findViewById(R.id.gender_male)
            //val genderFemale: RadioButton = findViewById(R.id.gender_male)
            val editCity: EditText = findViewById(R.id.edit_birthcity)
            val editProvincia: EditText = findViewById(R.id.edit_provincia)

            // leggere ciò che l'utente ha scritto
            val name: String = editName.text.toString()
            val surname: String = editSurname.text.toString()
            // 1-3-2000, 3-1-2000, 32-32-2000
            val birthdayStr: String = editDate.text.toString()
            val birthday: String = editDate.text.toString()
            val gender: Gender = if (genderMale.isChecked) Gender.Male else Gender.Female
            val city: String = editCity.text.toString()
            val provincia: String = editProvincia.text.toString()
            // attributi per poter trattare i dati anagrafici
            val data = Persona(name, surname, city, provincia, birthday, gender)
            Log.d("MainActivity", "Dati: $data")

            
            Executors.newSingleThreadExecutor().execute {
                Room.databaseBuilder(this, PersonaDatabase::class.java, "persona").build()
                    .getPersonaDao().save(data)
            }.also { finish() }


        }

    }
}