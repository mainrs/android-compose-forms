pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    plugins {
        id("com.android.application") version("7.2.0")
        id("com.android.library") version("7.2.0")
        id("org.jetbrains.kotlin.android") version("1.6.21")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "android-compose-forms"

include(":app")
include(":library")
include(":builtins")
include(":builtins-ui")

enableFeaturePreview("VERSION_CATALOGS")
