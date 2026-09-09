package com.wcrm.core.domain.repository

import com.wcrm.core.model.Warranty
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد دسترسی به اطلاعات گارانتی در لایه Domain.
 *
 * این قرارداد Core را از Room مستقل نگه می‌دارد و چرخه کامل ثبت، مشاهده،
 * ویرایش و حذف گارانتی را تعریف می‌کند.
 */
interface WarrantyRepository {

    /** جریان واکنشی تمام گارانتی‌ها را منتشر می‌کند. */
    fun observeWarranties(): Flow<List<Warranty>>

    /** گارانتی را بر اساس شناسه داخلی بازیابی می‌کند. */
    suspend fun getWarrantyById(id: Long): Warranty?

    /** گارانتی مرتبط با شماره سریال را بازیابی می‌کند. */
    suspend fun getWarrantyBySerialNumber(serialNumber: String): Warranty?

    /** گارانتی جدید را ثبت کرده و شناسه ایجادشده را برمی‌گرداند. */
    suspend fun addWarranty(warranty: Warranty): Long

    /** اطلاعات گارانتی موجود را به‌روزرسانی می‌کند. */
    suspend fun updateWarranty(warranty: Warranty)

    /** گارانتی را بر اساس شناسه حذف می‌کند. */
    suspend fun deleteWarranty(id: Long)
}
