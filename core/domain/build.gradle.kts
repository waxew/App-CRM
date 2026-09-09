plugins {
    alias(libs.plugins.kotlin.android)
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.kotlin.coroutines)
}
