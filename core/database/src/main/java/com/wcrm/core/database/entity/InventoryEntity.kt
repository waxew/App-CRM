package com.wcrm.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت ثبت گردش موجودی کالا در Room.
 *
 * هر رکورد نشان‌دهنده یک تغییر مشخص در موجودی یک محصول است. نگهداری گردش‌ها
 * به‌صورت مستقل امکان گزارش‌گیری و بازسازی تاریخچه تغییرات موجودی را فراهم می‌کند.
 *
 * @property id شناسه یکتای گردش موجودی که توسط Room تولید می‌شود.
 * @property productId شناسه محصولی که موجودی آن تغییر کرده است.
 * @property quantity مقدار تغییر موجودی.
 * @property movementType نوع گردش مانند ورود، خروج، فروش یا اصلاح.
 * @property createdAt زمان ثبت گردش موجودی.
 */
@Entity(tableName = "inventory_movements")
data class InventoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val productId: Long,
    val quantity: Int,
    val movementType: String,
    val createdAt: Long
)
