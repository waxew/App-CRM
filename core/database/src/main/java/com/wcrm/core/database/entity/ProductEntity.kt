package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت پایگاه‌داده محصول در Room.
 *
 * این Entity ساختار ذخیره‌سازی عمومی محصول را نگه می‌دارد. ویژگی‌های تخصصی هر
 * کسب‌وکار باید از طریق Business Profile مدیریت شوند تا ساختار Core عمومی باقی بماند.
 *
 * @property id شناسه یکتای محصول که توسط Room تولید می‌شود.
 * @property name نام محصول.
 * @property category دسته‌بندی محصول.
 * @property brand برند محصول.
 * @property price قیمت فروش.
 * @property cost قیمت تمام‌شده یا بهای خرید.
 * @property stock موجودی فعلی ثبت‌شده برای محصول.
 * @property createdAt زمان ایجاد رکورد محصول.
 * @property updatedAt زمان آخرین بروزرسانی رکورد محصول.
 */
@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val category: String? = null,
    val brand: String? = null,
    val price: Long,
    val cost: Long,
    val stock: Int,
    val createdAt: Long,
    val updatedAt: Long
)
