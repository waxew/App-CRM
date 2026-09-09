package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت ذخیره‌سازی تیکت تعمیر در Room.
 *
 * این جدول وضعیت عملیاتی تعمیرات مشتری را نگه می‌دارد و لایه Domain باید از طریق
 * Repository با آن تعامل کند؛ بنابراین Feature تعمیر نباید مستقیماً به این Entity وابسته شود.
 *
 * @property id شناسه یکتای تیکت تعمیر که توسط Room تولید می‌شود.
 * @property customerId شناسه مشتری صاحب دستگاه.
 * @property device شرح یا نام دستگاه تحویلی.
 * @property problem شرح مشکل اعلام‌شده.
 * @property status وضعیت فعلی فرآیند تعمیر.
 * @property cost هزینه ثبت‌شده برای تعمیر.
 */
@Entity(tableName = "repairs")
data class RepairEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val customerId: Long,
    val device: String,
    val problem: String,
    val status: String,
    val cost: Long
)
