package com.example.agendacontacto

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendacontacto.data.AppDatabase
import com.example.agendacontacto.data.Contact
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).contactDao()
    val contacts = dao.getAllContacts()

    fun addContact(name: String, phone: String) {
        viewModelScope.launch {
            dao.insert(Contact(name = name, phone = phone))
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            dao.delete(contact)
        }
    }
}
