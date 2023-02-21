package com.example.datianagrafici.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.datianagrafici.entity.Persona

@Dao
interface PersonaDao {

    /**
     * Salvare una  persona  sul database.
     */

    @Insert
    fun save(persona: Persona)

    /**
     * Recuperare o dati personali di una persona.
     * @return i dati della persona.
     */

    @Query("SELECT * FROM Persona ")
     fun getAll(): List<Persona>


}