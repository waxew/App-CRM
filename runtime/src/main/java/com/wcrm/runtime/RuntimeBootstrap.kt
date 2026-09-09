package com.wcrm.runtime

import com.wcrm.business.profile.registry.ProfileSchemaLoader
import com.wcrm.business.profile.schema.*

/**
 * وضعیت Runtime پس از بارگذاری و اعتبارسنجی Profile فعال.
 * Featureها باید از این Context بخوانند و نباید مستقیماً AppConfig را تفسیر کنند.
 */
data class RuntimeContext(
    val businessProfile: BusinessProfile
) {
    val attributes: List<AttributeDefinition> get() = businessProfile.attributes
    val dashboardWidgets: List<DashboardWidgetDefinition> get() = businessProfile.dashboardWidgets.sortedBy { it.order }
    val theme: ProfileThemeDefinition get() = businessProfile.theme
    val terminology: ProfileTerminology get() = businessProfile.terminology

    fun isModuleEnabled(module: BusinessModule): Boolean = module in businessProfile.enabledModules
}

/** نقطه شروع یکتای Runtime برای هر اجرای برنامه. */
object RuntimeBootstrap {
    fun initialize(): RuntimeContext {
        val schema = ProfileSchemaLoader.loadActive()
        return RuntimeContext(businessProfile = schema.profile)
    }
}
