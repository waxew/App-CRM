package com.wcrm.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wcrm.core.database.entity.InventoryEntity
import kotlinx.coroutines.flow.Flow

/**
 * درگاه دسترسی به داده‌های گردش موجودی در لایه Room.
 *
 * این DAO فقط مسئول ذخیره و بازیابی رویدادهای تغییر موجودی است.
 * قوانین کسب‌وکار مانند حداقل موجودی، هشدار کمبود و سیاست انبارداری
 * باید در لایه Domain پیاده‌سازی شوند.
 */
@Dao
interface InventoryDao {

    /** جریان تمام تغییرات موجودی را بر اساس زمان ثبت برمی‌گرداند. */
    @Query("SELECT * FROM inventory_movements ORDER BY createdAt DESC")
    fun observeMovements(): Flow<List<InventoryEntity>>

    /** گردش‌های مربوط به یک محصول مشخص را دریافت می‌کند. */
    @Query("SELECT * FROM inventory_movements WHERE productId = :productId ORDER BY createdAt DESC")
    fun observeProductMovements(productId: Long): Flow<List<InventoryEntity>>

    /** یک رکورد ورود یا خروج موجودی ثبت می‌کند. */
    @Insert
    suspend fun insertMovement(entity: InventoryEntity): Long
}
