package com.example.datianagrafici.dao

import androidx.room.Database
import com.example.datianagrafici.entity.Persona
import androidx.room.RoomDatabase

@Database(
    // versione attuale
    version = PersonaDatabase.VERSION,
    // entità gestite
    entities = [Persona::class]
)
abstract class PersonaDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "persona"
        const val VERSION = 1
    }

 abstract fun getPersonaDao(): PersonaDao

}
