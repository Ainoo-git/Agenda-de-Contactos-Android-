package com.curso20252026.agendacontactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.curso20252026.agendacontactos.ui.theme.AgendaContactosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgendaContactosTheme {
                AgendaContactos(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun AgendaContactos(modifier: Modifier = Modifier){
    Surface(modifier) {
        OnListScreen()
    }
}

@Composable
fun OnListScreen(modifier: Modifier = Modifier){

    //val contacts : List<String> = List(10) {"$it"}
    val contacts = listOf("Juan Perez","Pablo Lopez", "Gabriel Cuesta")
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Agenda de contactos")
        RenderListContacts(modifier, contacts)
    }
}

@Composable
fun RenderListContacts(modifier: Modifier = Modifier, contacts: List<String>){

    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = contacts){ name->
            RenderContact(contact = name)
        }
    }
}


@Composable
fun RenderContact(contact: String,modifier: Modifier = Modifier){
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ){
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)

        ){
            Text(text = contact)
        }

    }
}

