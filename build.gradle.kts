// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.qbitsmscollectoragenta1"
    compileSdk = 35
}

dependencies {
    // ... other dependencies ...
    //androidx.media3:media3-exoplayer:1.5.1
    implementation("androidx.media3:media3-exoplayer:1.5.0")

}