plugins {
    id("crypto.android.feature")
    id("crypto.android.library.compose")
    id("crypto.android.library.jacoco")
}

android {
    namespace = "com.emresahin.crypto.feature.coin_detail"
}

dependencies{
    implementation(project(":core:network"))
}
