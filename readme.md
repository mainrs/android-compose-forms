# Android Compose Forms

> A compose library for validating forms based on Kotlin Flows.

# Installation

First, make sure that https://jitpack.io has been declared as a Maven repository. Then just declare
the dependency either in Gradle

```groovy
dependencies {
    // Core library (usable without Compose).
    implementation 'com.github.mainrs:android-compose-forms:1.0.0'
    
    // Contains basic form validators.
    implementation 'com.github.mainrs:android-compose-forms-builtins:1.0.0'
    
    // Contains a FormField UI element based for Android Compose.
    implementation 'com.github.mainrs:android-compose-forms-builtins-ui:1.0.0'
}
```

or the new Kotlin DSL

```kotlin
dependencies {
    // Core library (usable without Compose).
    implementation("com.github.mainrs:android-compose-forms:1.0.0")
    
    // Contains basic form validators.
    implementation("com.github.mainrs:android-compose-forms-builtins:1.0.0")
    
    // Contains a FormField UI element based for Android Compose.
    implementation("com.github.mainrs:android-compose-forms-builtins-ui:1.0.0")
}
```

# Usage

See the example app for how to use the library.

# License

This project is licensed under the [MIT license](./license).
