plugins {
    id("crypto.android.library")
    id("crypto.android.library.jacoco")
    id("crypto.android.hilt")

}

android {
    namespace = "com.emresahin.crypto.core.common"

}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}