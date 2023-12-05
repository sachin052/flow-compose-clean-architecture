plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("de.mannodermaus.android-junit5") version "1.10.0.0"
}

android {
    compileSdkVersion = "android-34"


    defaultConfig {
        applicationId = "com.example.flowexample"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunnerArguments

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // Use JUnit 5 for local unit tests
        testInstrumentationRunnerArguments["runnerBuilder"] =
            "de.mannodermaus.junit5.AndroidJUnit5Builder"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        dataBinding = true
    }
    namespace = "com.example.flowexample"


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
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
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

    // Compose
    val composeBom = platform(Dependencies.composeBom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Material Design 3
    implementation(Dependencies.material3)

    // helps for checking preview and tooling
    androidCompseTooling()

    // navigation
    implementation(Dependencies.hiltNavigationCompose)
    implementation(Dependencies.navigationCompose)

    // (Required) Writing and executing Unit Tests on the JUnit Platform
    testImplementation(Dependencies.junitJupiterApi)
    testRuntimeOnly(Dependencies.junitJupiterEngine)

    // (Optional) If you need "Parameterized Tests"
    testImplementation(Dependencies.junitJupiterParams)

    // Assertion library (makes test assertion much more readable)
    testImplementation(Dependencies.assertk)

    // Mock
    testImplementation(Dependencies.mockitoKotlin)

    // Coroutine Test
    testImplementation(Dependencies.kotlinxCoroutinesTest)
    testImplementation(Dependencies.turbine)

    implementation(Dependencies.javapoet)


}
