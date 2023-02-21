package com.example.datianagrafici.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datianagrafici.R
import com.example.datianagrafici.entity.Persona

// Questa classe rappresenta una singola riga nella RecyclerView
class PersonaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val nameView: TextView
    private val dataView: TextView
    private val placeView: TextView
    private val surnameView: TextView

    /*
      Questo blocco di inizializzazione viene chiamato subito dopo la creazione dell'oggetto.
      Qui vengono inizializzati i campi dell'oggetto, recuperando i riferimenti ai TextView presenti nel layout.
      */

    init {
        nameView = view.findViewById(R.id.text_view_person_name)
        dataView = view.findViewById(R.id.text_view_person_birthday)
        placeView = view.findViewById(R.id.text_view_birthplace)
        surnameView = view.findViewById(R.id.text_view_person_surname)
    }

    // Metodo che viene utilizzato per visualizzare i dati della persona nella riga corrispondente.
    fun showPersona(persona: Persona) {
        nameView.text = persona.name
        dataView.text = persona.birthday
        placeView.text = persona.city
        surnameView.text = persona.surname

    }
}

// Questa classe rappresenta l'adapter che viene utilizzato per popolare la RecyclerView con i dati delle persone.
class PersonaAdapter(private val model: List<Persona>) : RecyclerView.Adapter<PersonaViewHolder>() {
    // metodo che viene chiamato per creare una nuova riga (ViewHolder) per la RecyclerView.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val template = LayoutInflater // gestore delle operazioni di "inflating"
            .from(parent.context) // contesto nel quale viene creato il layout
            // operazione di "ingrandimento" del layout all'interno dell'area a sua disposizione
            .inflate(R.layout.person_list_item, parent, false)
        return PersonaViewHolder(template)
    }

    // Questo metodo restituisce la dimensione della lista di persone
    override fun getItemCount(): Int = model.size

    // Questo metodo viene chiamato per associare i dati della persona alla riga corrispondente.
    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        holder.showPersona(model[position])
    }

}