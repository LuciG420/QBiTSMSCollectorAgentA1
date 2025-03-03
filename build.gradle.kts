// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.qbit.direct.qbitsmscollectoragentv1"
    compileSdk = 35
    //minSdk = 21
    // ... other settings
    defaultConfig {
        // ... other settings
        minSdk = 21
        // ... other settings
    }
    // ... other settings
    externalNativeBuild {
        cmake {
            path = file("app/src/main/cpp/CMakeLists.txt")
            version = "3.31.5"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17

    }
    buildFeatures {
        viewBinding = true
    }
    dependenciesInfo {
        includeInApk = true
        includeInBundle = true
    }
    buildToolsVersion = "35.0.1"
    ndkVersion = "27.0.12077973"

}

dependencies {
    // ... other dependencies ...
    //androidx.media3:media3-exoplayer:1.5.1
    implementation("androidx.media3:media3-exoplayer:1.5.1")
    implementation("com.google.android.gms:play-services-ads:23.6.0")
}
