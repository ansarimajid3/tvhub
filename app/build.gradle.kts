plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.stbemu"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.stbemu"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")

    // Compose TV
    implementation("androidx.tv:tv-material3:1.0.0-alpha14")
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.material3:material3:1.2.0-alpha01")
    implementation("androidx.activity:activity-compose:1.8.0")

    // Media3 / ExoPlayer
    implementation("androidx.media3:media3-exoplayer:1.2.2")
    implementation("androidx.media3:media3-ui:1.2.2")
    implementation("androidx.media3:media3-common:1.2.2")
    implementation("androidx.media3:media3-exoplayer-drm:1.2.2")
    implementation("androidx.media3:media3-datasource-okhttp:1.2.2")

    // Room for EPG
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Preferences
    implementation("androidx.preference:preference-ktx:1.2.0")
}
