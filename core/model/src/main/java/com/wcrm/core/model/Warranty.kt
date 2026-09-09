package com.wcrm.core.model

enum class WarrantyStatus {
    ACTIVE,
    EXPIRED,
    VOID,
    CLAIMED
}

data class Warranty(
    val id: Long = 0,
    val productId: Long,
    val serialNumber: String,
    val startDate: Long,
    val endDate: Long,
    val status: WarrantyStatus = WarrantyStatus.ACTIVE,
    val notes: String? = null
)
