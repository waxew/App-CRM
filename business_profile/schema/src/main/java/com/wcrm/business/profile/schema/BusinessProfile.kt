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
 * تعریف کامل یک پروفایل کسب‌وکار.
 * enabled فقط توسط توسعه‌دهنده تنظیم می‌شود و در UI گزینه انتخاب صنف نمایش داده نمی‌شود.
 */
data class BusinessProfile(
    val id: String,
    val name: String,
    val enabled: Boolean,
    val enabledModules: Set<BusinessModule>,
    val attributes: List<AttributeDefinition> = emptyList(),
    val visualKey: String = id
)
