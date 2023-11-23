import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project
object Dependencies {

    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"


    val retrofit="com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    val gsonConvertor="com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    val logginInterceptor="com.squareup.okhttp3:logging-interceptor:${Versions.logginInterceptorVersion}"
    
    val hiltAndroidCompiler="com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
    val hiltAndroid="com.google.dagger:hilt-android:${Versions.hiltVersion}"

    val lifeCycleExt= "androidx.lifecycle:lifecycle-extensions:2.2.0"
    val viewmodelKtx="androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleKtxVersion}"
    val liveDateKtx="androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleKtxVersion}"
    val lifeCycleRuntimeKtx="androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtxVersion}"
    val lifecycleComposeKtx="androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleKtxVersion}"

}

fun DependencyHandler.hilt(){
    implementation( Dependencies.hiltAndroid)
    kapt(Dependencies.hiltAndroidCompiler)
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
//
//fun DependencyHandler.compose() {
//    val Dependencies.composeUi)
//    val Dependencies.composeRuntime)
//    val Dependencies.composeUiGraphics)
//    val Dependencies.composeUiTooling)
//    val Dependencies.composeMaterial)
//    debugval Dependencies.composeUiToolingPreview)
//}
//
//fun DependencyHandler.hilt() {
//    val Dependencies.hiltAndroid)
//    kapt(Dependencies.hiltCompiler)
//}
//
//fun DependencyHandler.booksDataSource() {
//    val project(":books-datasource"))
//}
//
//fun DependencyHandler.booksUi() {
//    val project(":books-ui"))
//}