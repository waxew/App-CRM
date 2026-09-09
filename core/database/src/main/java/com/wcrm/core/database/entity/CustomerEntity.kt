package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers")
data class CustomerEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val phone: String,
    val mobile: String,
    val address: String?,
    val email: String?,
    val notes: String?,
    val createdAt: Long,
    val updatedAt: Long
)
