package com.wcrm.core.model

enum class RepairStatus {
    RECEIVED,
    DIAGNOSING,
    WAITING_FOR_PART,
    IN_PROGRESS,
    COMPLETED,
    DELIVERED,
    CANCELLED
}

data class RepairTicket(
    val id: Long = 0,
    val customerId: Long,
    val device: String,
    val problem: String,
    val status: RepairStatus = RepairStatus.RECEIVED,
    val cost: Long = 0,
    val notes: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
