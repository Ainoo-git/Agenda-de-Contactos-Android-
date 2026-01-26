package com.example.agendacontacto

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.agendacontacto.domain.Contact

@Composable
fun ContactListScreen(viewModel: ContactViewModel) {

    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showBottomSheet = true }) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(viewModel.contacts) { contact ->
                ContactItem(contact)
            }
        }
    }

    if (showBottomSheet) {
        AddContactBottomSheet(
            onAdd = { name, phone ->
                viewModel.addContact(name, phone)
                showBottomSheet = false
            },
            onDismiss = { showBottomSheet = false }
        )
    }
}

@Composable
fun AddContactBottomSheet(
    onAdd: (String, String) -> Unit,
    onDismiss: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    ModalBottomSheet(
        onDismissRequest = onDismiss
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text("Añadir contacto")

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre") }
            )

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Teléfono") }
            )

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = { onAdd(name, phone) },
                enabled = name.isNotBlank() && phone.isNotBlank()
            ) {
                Text("Guardar")
            }
        }
    }
}


@Composable
fun ContactItem(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = contact.name)
        Text(text = contact.phone)
    }
}


}
