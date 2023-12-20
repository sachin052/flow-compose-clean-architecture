plugins {
    id("com.android.library")
    kotlin("android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
    id("de.mannodermaus.android-junit5") version "1.10.0.0"
}

android {
    namespace = "com.example.auth"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // Use JUnit 5 for local unit tests
        testInstrumentationRunnerArguments["runnerBuilder"] =
            "de.mannodermaus.junit5.AndroidJUnit5Builder"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }
    hilt {
        enableAggregatingTask = false
    }
}

dependencies {
    implementation(project(mapOf("path" to ":core")))

    implementation(Dependencies.kotlinStdlib)
    implementation(Dependencies.appCompact)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.androidCoreKtx)
    implementation(Dependencies.activityKtx)

    // DI
    hilt()

    // COROUTINES
    implementation(Dependencies.coroutineAndroid)

    // LIFECYCLE
    lifecycleExtensionKtx()

    // navigation
    implementation(Dependencies.hiltNavigationCompose)
    implementation(Dependencies.navigationCompose)

    // Compose
    val composeBom = platform(Dependencies.composeBom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Material Design 3
    implementation(Dependencies.material3)

    // helps for checking preview and tooling
    androidCompseTooling()
    

    // (Required) Writing and executing Unit Tests on the JUnit Platform
    testImplementation(Dependencies.junitJupiterApi)
    testRuntimeOnly(Dependencies.junitJupiterEngine)

    // for"Parameterized Tests"
    testImplementation(Dependencies.junitJupiterParams)

    // Assertion library (makes test assertion much more readable)
    testImplementation(Dependencies.assertk)

    // Mock
    testImplementation(Dependencies.mockitoKotlin)

    // Coroutine Test
    testImplementation(Dependencies.kotlinxCoroutinesTest)
    testImplementation(Dependencies.turbine)
}