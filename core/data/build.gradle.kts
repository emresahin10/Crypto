plugins {
    id("crypto.android.library")
    id("crypto.android.hilt")
    id("crypto.android.library.jacoco")
    id("kotlinx-serialization")
}

android {
    namespace = "com.emresahin.crypto.core.data"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:network"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.firebase.auth)

}