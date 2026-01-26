package com.example.agendacontacto

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendacontacto.domain.Contact
import com.example.agendacontacto.repositories.ContactRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ContactViewModel : ViewModel() {

    private val _contacts = mutableStateListOf<Contact>()
    val contacts: List<Contact> = _contacts

    fun addContact(name: String, phone: String) {
        _contacts.add(
            Contact(
                id = _contacts.size,
                name = name,
                phone = phone
            )
        )
    }

    fun getContactById(id: Int): Contact? {
        return _contacts.find { it.id == id }
    }
}

