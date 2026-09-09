package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "invoices")
data class InvoiceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val customerId: Long,
    val totalAmount: Double,
    val paymentStatus: String,
    val createdAt: Long
)
