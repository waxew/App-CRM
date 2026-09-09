package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت ذخیره‌سازی ضمانت محصول در Room.
 *
 * این جدول تمام داده‌های پایه مدل Domain را نگه می‌دارد تا در فرآیند ذخیره‌سازی
 * هیچ اطلاعاتی از جمله شناسه محصول یا توضیحات گارانتی از بین نرود.
 *
 * @property id شناسه یکتای رکورد ضمانت که توسط Room تولید می‌شود.
 * @property productId شناسه محصول دارای ضمانت.
 * @property serialNumber شماره سریال محصول تحت ضمانت.
 * @property startDate زمان شروع ضمانت.
 * @property endDate زمان پایان ضمانت.
 * @property status وضعیت فعلی ضمانت به صورت مقدار متنی enum.
 * @property notes توضیحات اختیاری گارانتی.
 */
@Entity(tableName = "warranties")
data class WarrantyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val productId: Long,
    val serialNumber: String,
    val startDate: Long,
    val endDate: Long,
    val status: String,
    val notes: String? = null
)
