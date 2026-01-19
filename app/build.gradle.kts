plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}


android {
    namespace = "com.example.agendacontacto"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.agendacontacto"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    // Compose
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    // Room (KSP, NO KAPT)
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

}
