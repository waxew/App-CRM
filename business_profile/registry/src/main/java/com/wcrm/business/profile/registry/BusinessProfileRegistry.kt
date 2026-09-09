package com.wcrm.business.profile.registry

import com.wcrm.business.profile.profiles.AppBusinessProfiles
import com.wcrm.business.profile.schema.BusinessProfile

/**
 * مرجع واحد Profileها و محل اعتبارسنجی کاتالوگ.
 * انتخاب Profile از UI ممنوع است و Booleanهای AppConfig تنها منبع فعال‌سازی هستند.
 */
object BusinessProfileRegistry {
    private val profiles: List<BusinessProfile> by lazy {
        AppBusinessProfiles.all.also(::validateCatalog)
    }

    fun activeProfile(): BusinessProfile {
        val active = profiles.filter { it.enabled }
        require(active.size == 1) {
            "Exactly one Business Profile must be enabled in AppConfig. Current active count=${active.size}"
        }
        return active.single()
    }

    fun allProfiles(): List<BusinessProfile> = profiles

    /** خطاهای Definition را قبل از رسیدن به UI آشکار می‌کند. */
    private fun validateCatalog(items: List<BusinessProfile>) {
        require(items.isNotEmpty()) { "Business Profile catalog cannot be empty." }
        require(items.map { it.id }.distinct().size == items.size) { "Business Profile ids must be unique." }
        items.forEach { profile ->
            require(profile.id.isNotBlank() && profile.name.isNotBlank()) { "Profile id/name cannot be blank." }
            require(profile.attributes.map { it.id }.distinct().size == profile.attributes.size) {
                "Duplicate attribute id in ${profile.id}"
            }
            require(profile.dashboardWidgets.map { it.id }.distinct().size == profile.dashboardWidgets.size) {
                "Duplicate dashboard widget id in ${profile.id}"
            }
        }
    }
}
