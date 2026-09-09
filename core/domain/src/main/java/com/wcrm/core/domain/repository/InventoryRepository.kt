package com.wcrm.core.domain.repository

import com.wcrm.core.model.InventoryMovement
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد دسترسی به اطلاعات گردش موجودی در لایه Domain.
 *
 * این Interface باعث می‌شود قوانین کسب‌وکار موجودی از Room و جزئیات ذخیره‌سازی
 * مستقل باقی بمانند.
 */
interface InventoryRepository {

    /** جریان واکنشی تمام تغییرات موجودی را برمی‌گرداند. */
    fun observeInventoryMovements(): Flow<List<InventoryMovement>>

    /** گردش‌های یک محصول مشخص را به صورت واکنشی برمی‌گرداند. */
    fun observeProductMovements(productId: Long): Flow<List<InventoryMovement>>

    /** یک گردش جدید موجودی ثبت می‌کند و شناسه رکورد را برمی‌گرداند. */
    suspend fun addInventoryMovement(movement: InventoryMovement): Long
}
