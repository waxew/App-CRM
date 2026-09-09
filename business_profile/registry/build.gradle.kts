plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.wcrm.businessprofile.registry"
    compileSdk = 35

    defaultConfig { minSdk = 26 }
}

kotlin { jvmToolchain(17) }

dependencies {
    implementation(project(":business_profile:schema"))
}
