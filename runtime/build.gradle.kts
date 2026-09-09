plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.wcrm.runtime"
    compileSdk = 35

    defaultConfig {
        minSdk = 26
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:domain"))
    implementation(project(":core:database"))
    implementation(project(":core:repository"))
    implementation(project(":business_profile:schema"))
    implementation(project(":business_profile:registry"))
    implementation(project(":business_profile:validator"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
