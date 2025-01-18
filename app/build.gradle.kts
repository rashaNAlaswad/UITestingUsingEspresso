plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.uiautomationtestingusingespresso"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.uiautomationtestingusingespresso"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    testImplementation (libs.androidx.monitor)

    // Espresso dependencies
    androidTestImplementation (libs.espresso.core)
    androidTestImplementation (libs.androidx.runner.v152)
    androidTestImplementation (libs.androidx.rules.v150)
    androidTestImplementation (libs.androidx.espresso.contrib)
    // Espresso Intents for testing navigation and intents
    androidTestImplementation (libs.androidx.espresso.intents)

    // Core testing library
    androidTestImplementation (libs.androidx.core)
}