plugins{
    `kotlin-dsl`
//    id("com.google.dagger.hilt.android")
}
repositories{
    google()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    implementation("com.android.tools.build:gradle:8.1.2")
//    classpath("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
}