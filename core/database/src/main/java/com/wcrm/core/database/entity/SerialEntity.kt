package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت ذخیره‌سازی شناسه‌های سریالی محصول در Room.
 *
 * این Entity برای کالاهایی استفاده می‌شود که باید با IMEI یا شماره سریال رهگیری شوند.
 * ارتباط آن با Product از طریق productId برقرار می‌شود تا قابلیت رهگیری مستقل از
 * Business Profile حفظ شود.
 *
 * @property id شناسه یکتای رکورد سریال که توسط Room تولید می‌شود.
 * @property imei شناسه IMEI در صورت وجود.
 * @property serialNumber شماره سریال محصول در صورت وجود.
 * @property productId شناسه محصول مرتبط با این شناسه سریالی.
 * @property createdAt زمان ثبت رکورد سریال در سیستم.
 */
@Entity(tableName = "serials")
data class SerialEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val imei: String? = null,
    val serialNumber: String? = null,
    val productId: Long,
    val createdAt: Long
)
