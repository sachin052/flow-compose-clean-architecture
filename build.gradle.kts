buildscript {
//    ext {
//        kotlin_version = '1.9.0'
//        coroutines_version = '1.7.1'
//        nav_version = '2.3.5'
//        material_version = '1.3.0'
//        hilt_version = '2.48.1'
//        either_version = '3.0.0'
//        glide_version = '4.12.0'
//        retrofit_version = '2.9.0'
//        billing_version = '3.0.3'
//        work_version = '2.5.0'
//        permissions_dispatcher = "4.8.0"
//        firebase_ui = '7.1.1'
//        agp_version = '8.1.2'
//    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48.1")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
//
//task clean(type: Delete) {
//    delete rootProject.buildDir
//}