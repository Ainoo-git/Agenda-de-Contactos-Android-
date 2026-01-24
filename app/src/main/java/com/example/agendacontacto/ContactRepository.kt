package com.example.agendacontacto.repositories

import com.example.agendacontacto.dao.ContactDao
import com.example.agendacontacto.data.ContactEntity
import com.example.agendacontacto.domain.Contact
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ContactRepository(private val dao: ContactDao) {

    fun getAllContacts(): Flow<List<Contact>> =
        dao.getAllContacts().map { list ->
            list.map { Contact(it.id, it.name, it.phone) }
        }

    suspend fun insert(contact: Contact) {
        dao.insert(ContactEntity(contact.id, contact.name, contact.phone))
    }
}
