package com.example.datianagrafici.servizi


import com.example.datianagrafici.entity.Persona


/**
 * Service che si occupa della gestione dei dati relativi alle persone
 */

interface IPersonaServices {
    /**
     * Funzione che si occupa dell'aggiunta di una persona
     * @param person: Person
     * @return Unit
     */
    fun addPerson(person: Persona): Unit

    /**
     * Funzione che si occupa della rimozione di una persona
     * @param person: Person
     * @return Unit
     */
    fun removePerson(person: Persona): Unit

    /**
     * Funzione che si occupa di ritornare tutte le persone salvate in una lista
     * @return List<Person>
     */
    fun getAllPersons(): List<Persona>

}
