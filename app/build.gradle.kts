plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion = "android-34"


    defaultConfig {
        applicationId = "com.example.flowexample"
        minSdkVersion(21)
        targetSdkVersion(34)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary  = true
        }
    }

    buildFeatures {
        dataBinding = true
    }
    namespace = "com.example.flowexample"

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }

    packaging {
        resources {
            exclude("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
//    testOptions {
//        unitTests.returnDefaultValues = true
//    }
}

dependencies {
        val kotlin_version = "1.9.0"
        val coroutines_version = "1.7.1"
        val nav_version = "2.3.5"
        val material_version = "1.3.0"
        val hilt_version = "2.48.1"
        val either_version = "3.0.0"
        val glide_version = "4.12.0"
        val retrofit_version = "2.9.0"
        val billing_version = "3.0.3"
        val work_version = "2.5.0"
        val permissions_dispatcher = "4.8.0"
        val firebase_ui = "7.1.1"
        val agp_version = "8.1.2"

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui-graphics")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    // NETWORKING
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("com.treebo:internetavailabilitychecker:1.0.4")

    // DI
    implementation("com.google.dagger:hilt-android:$hilt_version")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    kapt("com.google.dagger:hilt-android-compiler:$hilt_version")

    // COROUTINES
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // LIFECYCLE
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    // UI
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation("androidx.activity:activity-ktx:1.8.1")

    val composeBom = platform("androidx.compose:compose-bom:2023.10.01")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Choose one of the following:
    // Material Design 3
    implementation("androidx.compose.material3:material3")
    // or Material Design 2
    implementation("androidx.compose.material:material")
    // or skip Material Design and build directly on top of foundational components
    implementation("androidx.compose.foundation:foundation")
    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    implementation("androidx.compose.ui:ui")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")

    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    implementation("androidx.navigation:navigation-compose:2.7.5")


    // Kotest
    testImplementation("io.kotest:kotest-runner-junit5:4.6.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testImplementation("io.kotest:kotest-assertions-core:4.6.1")
    testImplementation("io.mockk:mockk:1.12.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
    testImplementation("app.cash.turbine:turbine:1.0.0")


    // Coroutine Test
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")

}
