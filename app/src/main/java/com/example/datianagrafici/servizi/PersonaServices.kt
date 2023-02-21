package com.example.datianagrafici.servizi

import com.example.datianagrafici.entity.Gender
import com.example.datianagrafici.entity.Persona

class PersonaServices : IPersonaServices {
    companion object {
        val personList: MutableList<Persona> = mutableListOf(
            Persona("Mario", "rossi", "Milano", "MI", "12/12/12", Gender.Male),
            Persona("Lucia", "Bianchi", "Torino", "TO", "12/05/1987", Gender.Female),
            Persona("Luigi", "Mario", "Venezia", "VE", "06/11/1983", Gender.Male)
        )

    }

    override fun addPerson(person: Persona) {
        personList.add(person)
    }

    override fun removePerson(person: Persona) {
        personList.remove(person)
    }

    override fun getAllPersons(): List<Persona> = personList
}
