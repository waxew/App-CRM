package com.wcrm.business.profile.schema

enum class BusinessModule {
    CUSTOMER,
    PRODUCT,
    INVENTORY,
    SALES,
    INVOICE,
    WARRANTY,
    REPAIR,
    ACCOUNTING,
    DELIVERY,
    SERIAL_MANAGEMENT
}

/**
 * قرارداد کامل یک Business Profile.
 * انتخاب صنف فقط در AppConfig انجام می‌شود؛ UI اجازه تغییر Profile را ندارد.
 * تمام فیلدها، ویجت‌ها، واژگان و کلیدهای بصری از همین قرارداد خوانده می‌شوند.
 */
data class BusinessProfile(
    val id: String,
    val name: String,
    val enabled: Boolean,
    val enabledModules: Set<BusinessModule>,
    val attributes: List<AttributeDefinition> = emptyList(),
    val dashboardWidgets: List<DashboardWidgetDefinition> = emptyList(),
    val theme: ProfileThemeDefinition = ProfileThemeDefinition(id, id, id),
    val terminology: ProfileTerminology = ProfileTerminology(),
    val visualKey: String = id
)
