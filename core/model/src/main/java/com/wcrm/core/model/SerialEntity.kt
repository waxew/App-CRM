package com.wcrm.core.model

data class SerialEntity(
    val id: Long = 0,
    val productId: Long,
    val imei: String? = null,
    val serialNumber: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)
