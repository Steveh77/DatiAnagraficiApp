package com.example.datianagrafici.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Gender { Male, Female }

/*
  Questa annotazione indica che questa classe rappresenta un'entità della base di dati, quindi
  Room creerà una tabella con lo stesso nome di questa classe e con le colonne corrispondenti alle
  proprietà pubbliche della classe.
*/

@Entity

data class Persona(
    val name: String,
    val surname: String,
    val city: String,
    val provincia: String,
    val birthday: String,
    val gender: Gender

) {
    /*
    Questa annotazione indica che il campo "id" è la chiave primaria della tabella.
    La proprietà "autoGenerate" indica che il valore dell'id verrà generato automaticamente
    da Room al momento dell'inserimento in base di dati.
     */

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    /*
        Questo metodo viene utilizzato per ottenere una rappresentazione testuale della persona.
        La rappresentazione ha il formato "Nome Cognome (data di nascita) Sede" dove "Sesso" è
        rappresentato dalla lettera "M" o "F".
     */
    override fun toString(): String {
        return "$name $surname ($birthday) " +
                "${if (gender == Gender.Male) 'M' else 'F'}" +
                " $city"
    }
}

