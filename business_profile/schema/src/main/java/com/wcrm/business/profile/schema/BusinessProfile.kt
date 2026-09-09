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

data class BusinessProfile(
    val id: String,
    val name: String,
    val enabledModules: Set<BusinessModule>,
    val attributes: List<AttributeDefinition> = emptyList()
)
