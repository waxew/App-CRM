package com.wcrm.core.domain.repository

import com.wcrm.core.model.Serial
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد دسترسی به اطلاعات IMEI و شماره سریال.
 *
 * این لایه مستقل از Room است و فقط رفتار مورد نیاز Domain را تعریف می‌کند.
 */
interface SerialRepository {
    fun observeSerials(): Flow<List<Serial>>
    suspend fun getById(id: Long): Serial?
    suspend fun addSerial(serial: Serial): Long
    suspend fun deleteSerial(id: Long)
}
