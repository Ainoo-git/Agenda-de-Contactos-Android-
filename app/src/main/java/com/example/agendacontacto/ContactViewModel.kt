package com.example.agendacontacto

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendacontacto.domain.Contact
import com.example.agendacontacto.repositories.ContactRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).contactDao()
    private val repository = ContactRepository(dao)

    val contacts = repository
        .getAllContacts()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            emptyList()
        )

    init {
        viewModelScope.launch {
            repository.insert(Contact(name = "Juan", phone = "123456"))
            repository.insert(Contact(name = "Pablo", phone = "987654"))
        }
    }
}
