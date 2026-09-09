package com.wcrm.runtime

import com.wcrm.business.profile.registry.BusinessProfileRegistry
import com.wcrm.business.profile.schema.BusinessModule
import com.wcrm.business.profile.schema.BusinessProfile

/** وضعیت Runtime برنامه پس از اعتبارسنجی AppConfig و Business Profile. */
data class RuntimeContext(
    val businessProfile: BusinessProfile
) {
    fun isModuleEnabled(module: BusinessModule): Boolean =
        module in businessProfile.enabledModules
}

/** نقطه شروع Runtime برای هر اجرای برنامه. */
object RuntimeBootstrap {
    fun initialize(): RuntimeContext = RuntimeContext(
        businessProfile = BusinessProfileRegistry.activeProfile()
    )
}
