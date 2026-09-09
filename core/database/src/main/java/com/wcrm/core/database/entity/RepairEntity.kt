package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت ذخیره‌سازی تیکت تعمیر در Room.
 *
 * این جدول اطلاعات کامل هر درخواست تعمیر را نگه می‌دارد. Feature تعمیر نباید
 * مستقیماً به این Entity وابسته باشد و دسترسی باید از مسیر Repository انجام شود.
 */
@Entity(tableName = "repairs")
data class RepairEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val customerId: Long,
    val device: String,
    val problem: String,
    val status: String,
    val cost: Long,
    val notes: String? = null,
    val createdAt: Long,
    val updatedAt: Long
)
