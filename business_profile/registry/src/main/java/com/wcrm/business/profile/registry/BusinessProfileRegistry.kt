package com.wcrm.business.profile.registry

import com.wcrm.business.profile.profiles.AppBusinessProfiles
import com.wcrm.business.profile.schema.BusinessProfile

/**
 * مرجع واحد تشخیص پروفایل فعال برنامه.
 * انتخاب از داخل UI مجاز نیست و فقط Booleanهای AppConfig تعیین‌کننده هستند.
 */
object BusinessProfileRegistry {
    fun activeProfile(): BusinessProfile {
        val active = AppBusinessProfiles.all.filter { it.enabled }
        require(active.size == 1) {
            "Exactly one Business Profile must be enabled in AppConfig. Current active count=${active.size}"
        }
        return active.single()
    }

    fun allProfiles(): List<BusinessProfile> = AppBusinessProfiles.all
}
