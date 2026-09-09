package com.wcrm.core.model.customer

import java.time.Instant

/**
 * Core CRM customer entity.
 * Independent from business profiles.
 */
data class Customer(
    val id: Long,
    val name: String,
    val phone: String?,
    val mobile: String?,
    val address: String?,
    val email: String?,
    val createdAt: Instant,
    val updatedAt: Instant,
    val notes: String?
)
