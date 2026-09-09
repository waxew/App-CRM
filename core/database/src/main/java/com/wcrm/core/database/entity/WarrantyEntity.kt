package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت ذخیره‌سازی ضمانت محصول در Room.
 *
 * این جدول اطلاعات اصلی دوره ضمانت را نگه می‌دارد. وضعیت ضمانت به‌صورت مقدار متنی
 * ذخیره می‌شود و تبدیل آن به مدل Domain باید در Repository انجام شود.
 *
 * @property id شناسه یکتای رکورد ضمانت که توسط Room تولید می‌شود.
 * @property serialNumber شماره سریال محصول تحت ضمانت.
 * @property startDate زمان شروع ضمانت.
 * @property endDate زمان پایان ضمانت.
 * @property status وضعیت فعلی ضمانت.
 */
@Entity(tableName = "warranties")
data class WarrantyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val serialNumber: String,
    val startDate: Long,
    val endDate: Long,
    val status: String
)
