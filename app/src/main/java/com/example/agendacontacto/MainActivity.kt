package com.example.agendacontacto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.agendacontacto.ui.theme.AgendaContactoTheme
import com.example.agendacontacto.ui.theme.AgendaContactoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgendaContactoTheme {
                ContactListScreen()
            }
        }
    }
}

@Composable
fun ContactListScreen(viewModel: ContactViewModel = viewModel()) {
    val contacts by viewModel.contacts.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Agenda de contactos", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(contacts) { contact ->
                Text(
                    text = "${contact.name} - ${contact.phone}",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
