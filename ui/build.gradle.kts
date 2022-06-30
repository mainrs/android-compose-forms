plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

group = "com.github.mainrs"
version = "1.0.0"

android {
    namespace = "net.zerotask.libraries.android.compose.forms.ui"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        aarMetadata {
            minCompileSdk = 21
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-rc02"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(libs.bundles.builtins.ui)
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = "com.github.mainrs"
                artifactId = "android-compose-forms-ui"
                version = "1.0.0"

                afterEvaluate {
                    from(components["release"])
                }
            }
        }
    }
}
