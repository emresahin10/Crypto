plugins {
    id("crypto.android.feature")
    id("crypto.android.library.compose")
    id("crypto.android.library.jacoco")
}

android {
    namespace = "com.emresahin.crypto.feature.search"
}

dependencies{
    implementation(project(":core:network"))
}
