package com.wcrm.business.profile.registry

import com.wcrm.business.profile.schema.BusinessProfile

/**
 * خروجی نهایی Schema Loader برای مصرف Runtime و UI.
 * این لایه تنها Profile فعال را بارگذاری می‌کند و جزئیات Registry را از مصرف‌کننده پنهان نگه می‌دارد.
 */
data class LoadedProfileSchema(
    val profile: BusinessProfile
)

object ProfileSchemaLoader {
    /** Schema کامل پروفایل فعال را برمی‌گرداند. */
    fun loadActive(): LoadedProfileSchema = LoadedProfileSchema(
        profile = BusinessProfileRegistry.activeProfile()
    )

    /** برای ابزارهای توسعه و تست امکان خواندن تعریف هر Profile با شناسه وجود دارد. */
    fun loadById(id: String): LoadedProfileSchema = LoadedProfileSchema(
        profile = BusinessProfileRegistry.allProfiles().firstOrNull { it.id == id }
            ?: error("Business Profile not found: $id")
    )
}
