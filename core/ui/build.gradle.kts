plugins {
    id("crypto.android.library")
    id("crypto.android.library.compose")
    id("crypto.android.library.jacoco")
}

android {
    namespace = "com.emresahin.crypto.core.ui"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.kotlinx.datetime)
    implementation(libs.airbnb.lottie)
    api(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.window.manager)
    debugApi(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.compose.runtime.livedata)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    api(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.runtime.livedata)
    api(libs.androidx.tracing.ktx)
    api(libs.kotlinx.collections)

}

