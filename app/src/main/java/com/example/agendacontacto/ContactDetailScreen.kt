package com.example.agendacontacto

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.agendacontacto.domain.Contact

@Composable
    fun ContactDetailScreen(contact: Contact) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Nombre: ${contact.name}")
            Text(text = "Teléfono: ${contact.phone}")
        }
    }


