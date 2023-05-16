plugins {
    id("crypto.android.library")
    id("crypto.android.library.jacoco")
}

android {
    namespace = "com.emresahin.crypto.core.domain"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
}