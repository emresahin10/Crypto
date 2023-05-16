plugins {
    id("crypto.android.feature")
    id("crypto.android.library.compose")
    id("crypto.android.library.jacoco")
}

android {
    namespace = "com.emresahin.crypto.feature.my_coins"
}

dependencies{
    implementation(project(":core:network"))
    implementation(libs.firebase.firestore)

}
