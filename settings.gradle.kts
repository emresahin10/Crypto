pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

plugins {
    // See https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions") version "0.51.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
rootProject.name = "Crypto"
include (":app")
include(":core:common")
include(":core:data")
include(":core:domain")
include(":core:model")
include(":core:network")
include(":core:ui")
include(":feature:authentication")
include(":feature:markets")
include(":feature:search")
include(":feature:coin-detail")
include(":feature:my-coins")
