package com.wcrm.core.domain.repository

import com.wcrm.core.model.Inventory
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد دسترسی به اطلاعات گردش موجودی در لایه Domain.
 *
 * این Interface باعث می‌شود قوانین کسب‌وکار موجودی از Room و جزئیات ذخیره‌سازی
 * مستقل باقی بمانند.
 */
interface InventoryRepository {

    /** جریان واکنشی تمام تغییرات موجودی را برمی‌گرداند. */
    fun observeInventoryMovements(): Flow<List<Inventory>>

    /** یک گردش جدید موجودی ثبت می‌کند. */
    suspend fun addInventoryMovement(inventory: Inventory): Long
}
