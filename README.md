# 📱 Agenda de Contactos (Android)

Aplicación Android desarrollada en **Kotlin** utilizando **Jetpack Compose** y **Room** como base de datos local.  
Permite gestionar una agenda de contactos de forma sencilla y persistente.

---

##  Características

- Lista de contactos
- Añadir contactos (nombre y teléfono)
- Eliminar contactos tocando sobre ellos
- Persistencia de datos con Room (los contactos se mantienen al cerrar la app)
- Interfaz moderna con Jetpack Compose
- Arquitectura MVVM

---

## 🛠️ Tecnologías utilizadas

- **Kotlin**
- **Android Studio**
- **Jetpack Compose**
- **Room Database**
- **ViewModel**
- **Coroutines**
- **Flow**

---

## Arquitectura

El proyecto sigue el patrón **MVVM (Model–View–ViewModel)**:

UI (Compose)
↓
ViewModel
↓
Room (DAO + Database)

---

## Estructura del proyecto

app/src/main/java/com/example/agendacontacto/
├─ data/
│ ├─ Contact.kt
│ ├─ ContactDao.kt
│ └─ AppDatabase.kt
├─ ContactViewModel.kt
└─ MainActivity.kt

---

## Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/agenda-contactos.git
Abre el proyecto en Android Studio

Espera a que Gradle termine de sincronizar

Ejecuta la app en un emulador o dispositivo físico

 ---
## Funcionamiento
Introduce un nombre y un teléfono

Pulsa Guardar

El contacto aparece en la lista

Pulsa sobre un contacto para eliminarlo

Al cerrar y abrir la app, los contactos siguen guardados

---


Hecho por Ainoha
Proyecto realizado como práctica de desarrollo Android con Kotlin y Jetpack Compose.

Licencia
Este proyecto se distribuye bajo la licencia MIT.

---

# AgendaContactos
