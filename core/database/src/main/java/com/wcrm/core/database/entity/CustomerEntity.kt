package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت پایگاه‌داده مشتری در Room.
 *
 * این کلاس فقط نمایش ذخیره‌سازی مشتری در لایه Database است و نباید مستقیماً
 * در UI یا منطق دامنه استفاده شود. تبدیل بین این Entity و مدل Domain باید در
 * لایه Repository/Data انجام شود تا Core Domain از Room مستقل بماند.
 *
 * @property id شناسه یکتای مشتری در جدول customers.
 * @property name نام مشتری.
 * @property phone شماره تلفن ثابت مشتری.
 * @property mobile شماره موبایل مشتری.
 * @property address آدرس مشتری در صورت ثبت.
 * @property email ایمیل مشتری در صورت ثبت.
 * @property notes یادداشت‌های تکمیلی مربوط به مشتری.
 * @property createdAt زمان ایجاد رکورد.
 * @property updatedAt زمان آخرین بروزرسانی رکورد.
 */
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
