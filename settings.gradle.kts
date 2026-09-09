pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "W-CRM"

include(":app")
include(":core:common")
include(":core:model")
include(":core:domain")
include(":core:database")
include(":core:repository")
include(":business_profile:schema")
include(":business_profile:profiles")
include(":business_profile:registry")
include(":business_profile:validator")
include(":runtime")

include(":feature:customer")
include(":feature:product")
include(":feature:inventory")
include(":feature:sales")
include(":feature:invoice")
include(":feature:warranty")
include(":feature:repair")
include(":feature:accounting")
