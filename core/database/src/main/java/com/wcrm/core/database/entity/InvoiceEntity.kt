package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت اصلی فاکتور در پایگاه‌داده Room.
 *
 * اطلاعات سربرگ فاکتور در این جدول نگهداری می‌شود و اقلام هر فاکتور در جدول
 * `invoice_items` ذخیره می‌شوند تا ساختار داده نرمال، قابل توسعه و مناسب گزارش‌گیری باقی بماند.
 *
 * @property id شناسه یکتای فاکتور که توسط Room تولید می‌شود.
 * @property customerId شناسه مشتری مرتبط؛ برای فروش ناشناس می‌تواند null باشد.
 * @property totalAmount مبلغ نهایی فاکتور در واحد پول پایه برنامه.
 * @property paymentStatus وضعیت پرداخت به‌صورت نام enum دامنه.
 * @property createdAt زمان ایجاد فاکتور به میلی‌ثانیه Unix.
 * @property updatedAt زمان آخرین بروزرسانی فاکتور به میلی‌ثانیه Unix.
 */
@Entity(tableName = "invoices")
data class InvoiceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val customerId: Long? = null,
    val totalAmount: Long,
    val paymentStatus: String,
    val createdAt: Long,
    val updatedAt: Long
)
