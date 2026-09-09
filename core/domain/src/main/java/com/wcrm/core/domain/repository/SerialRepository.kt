package com.wcrm.core.domain.repository

import com.wcrm.core.model.SerialEntity
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد دسترسی به اطلاعات IMEI و شماره سریال در لایه Domain.
 *
 * این قرارداد مستقل از Room است و فقط رفتار مورد نیاز هسته CRM را تعریف می‌کند.
 */
interface SerialRepository {
    /** جریان واکنشی تمام رکوردهای سریال و IMEI را منتشر می‌کند. */
    fun observeSerials(): Flow<List<SerialEntity>>

    /** یک رکورد سریال را با شناسه یکتا دریافت می‌کند. */
    suspend fun getById(id: Long): SerialEntity?

    /** یک رکورد سریال یا IMEI جدید ثبت می‌کند و شناسه ایجادشده را برمی‌گرداند. */
    suspend fun addSerial(serial: SerialEntity): Long

    /** رکورد سریال را بر اساس شناسه حذف می‌کند. */
    suspend fun deleteSerial(id: Long)
}
