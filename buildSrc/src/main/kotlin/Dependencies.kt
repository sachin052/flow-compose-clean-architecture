import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    //UI
    const val material3="androidx.compose.material3:material3"
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBomVersion}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"


    // retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val logginInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.logginInterceptorVersion}"

    // hilt
    const val hiltAndroidCompiler =
        "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"

    // kotlin Ktx
    const val lifeCycleExt = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val viewmodelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleKtxVersion}"
    const val liveDateKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleKtxVersion}"
    const val lifeCycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtxVersion}"
    const val lifecycleComposeKtx =
        "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleKtxVersion}"
    const val activityKtx = "androidx.core:core-ktx:${Versions.composeVersion}}"

    const val appCompact = "androidx.appcompat:appcompat:${Versions.appCompact}"
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.composeVersion}"
    const val androidCoreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"

    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_version}"

    // navigation
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationComposeVersion}"
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigationComposeVersion}"

    // (Required) Writing and executing Unit Tests on the JUnit Platform
    const val junitJupiterApi =
        "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiterVersion}"
    const val junitJupiterEngine =
        "org.junit.jupiter:junit-jupiter-engine:${Versions.junitJupiterVersion}"

    // (Optional) If you need "Parameterized Tests"
    const val junitJupiterParams =
        "org.junit.jupiter:junit-jupiter-params:${Versions.junitJupiterVersion}"

    // Assertion library (makes test assertion much more readable)
    const val assertk = "com.willowtreeapps.assertk:assertk:${Versions.assertkVersion}"

    // Mock
    const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlinVersion}"

    // Coroutine Test
    const val kotlinxCoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinxCoroutinesTestVersion}"
    const val turbine = "app.cash.turbine:turbine:${Versions.turbineVersion}"

    const val javapoet = "com.squareup:javapoet:${Versions.javapoetVersion}"
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeUITooling = "androidx.compose.ui:ui-tooling"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterialVersion}"


}

fun DependencyHandler.hilt() {
    api(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltAndroidCompiler)
}

fun DependencyHandler.androidCompseTooling(){
    // Android Studio Preview support
    implementation(Dependencies.composeToolingPreview)
    debugImplementation(Dependencies.composeUITooling)
}

fun DependencyHandler.retrofit() {
    api(Dependencies.retrofit)
    api(Dependencies.gsonConvertor)
    api(Dependencies.logginInterceptor)
}

fun DependencyHandler.lifecycleExtensionKtx() {
    implementation(Dependencies.lifeCycleExt)
    implementation(Dependencies.viewmodelKtx)
    implementation(Dependencies.liveDateKtx)
    implementation(Dependencies.lifeCycleRuntimeKtx)
    implementation(Dependencies.lifecycleComposeKtx)
}
