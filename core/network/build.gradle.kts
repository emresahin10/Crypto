plugins {
    id("crypto.android.library")
    id("crypto.android.hilt")
    id("crypto.android.library.jacoco")
    id("kotlinx-serialization")

}

android {
    namespace = "com.emresahin.crypto.core.network"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.coil.kt)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.storage)
}