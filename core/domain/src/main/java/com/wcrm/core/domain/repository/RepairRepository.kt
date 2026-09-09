package com.wcrm.core.domain.repository

import com.wcrm.core.model.RepairTicket
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد دسترسی به تیکت‌های تعمیر در لایه Domain.
 *
 * این قرارداد وابستگی Domain را از Room و جزئیات ذخیره‌سازی جدا نگه می‌دارد.
 */
interface RepairRepository {

    /** جریان همه تیکت‌های تعمیر را منتشر می‌کند. */
    fun observeRepairs(): Flow<List<RepairTicket>>

    /** تیکت مشخص را با شناسه یکتا دریافت می‌کند. */
    suspend fun getRepairById(id: Long): RepairTicket?

    /** تاریخچه تعمیرات یک مشتری را منتشر می‌کند. */
    fun observeCustomerRepairs(customerId: Long): Flow<List<RepairTicket>>

    /** تیکت جدید ایجاد کرده و شناسه آن را برمی‌گرداند. */
    suspend fun createRepair(ticket: RepairTicket): Long

    /** اطلاعات تیکت را به‌روزرسانی می‌کند. */
    suspend fun updateRepair(ticket: RepairTicket)

    /** تیکت را با شناسه حذف می‌کند. */
    suspend fun deleteRepair(id: Long)
}
