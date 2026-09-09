package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت پایگاه‌داده فاکتور در Room.
 *
 * این کلاس اطلاعات اصلی هر فاکتور را در جدول invoices نگهداری می‌کند. جزئیات
 * اقلام فاکتور باید در ساختار مستقل خود مدیریت شوند تا مدل ذخیره‌سازی قابل توسعه بماند.
 *
 * @property id شناسه یکتای فاکتور که توسط Room تولید می‌شود.
 * @property customerId شناسه مشتری مرتبط با فاکتور.
 * @property totalAmount مبلغ کل فاکتور.
 * @property paymentStatus وضعیت پرداخت فاکتور به‌صورت مقدار قابل ذخیره در دیتابیس.
 * @property createdAt زمان ایجاد فاکتور.
 */
@Entity(tableName = "invoices")
data class InvoiceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val customerId: Long,
    val totalAmount: Double,
    val paymentStatus: String,
    val createdAt: Long
)
