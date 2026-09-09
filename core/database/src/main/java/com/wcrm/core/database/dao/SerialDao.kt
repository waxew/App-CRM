package com.wcrm.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.wcrm.core.database.entity.SerialEntity
import kotlinx.coroutines.flow.Flow

/**
 * درگاه دسترسی به داده‌های IMEI و شماره‌سریال در پایگاه‌داده.
 *
 * این DAO فقط مسئول عملیات داده‌ای است. قواعدی مانند یکتا بودن IMEI،
 * اعتبار قالب یا سیاست اتصال سریال به محصول باید در Domain/Repository مدیریت شوند.
 */
@Dao
interface SerialDao {
    /** جریان همه سریال‌ها و IMEIها را از جدیدترین رکورد منتشر می‌کند. */
    @Query("SELECT * FROM serials ORDER BY createdAt DESC")
    fun observeSerials(): Flow<List<SerialEntity>>

    /** یک رکورد را با شناسه یکتا دریافت می‌کند. */
    @Query("SELECT * FROM serials WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): SerialEntity?

    /** سریال یا IMEI را دقیقاً بر اساس مقدار آن جست‌وجو می‌کند. */
    @Query("SELECT * FROM serials WHERE imei = :value OR serialNumber = :value LIMIT 1")
    suspend fun findBySerialOrImei(value: String): SerialEntity?

    /** تمام شناسه‌های سریالی متعلق به یک محصول را برمی‌گرداند. */
    @Query("SELECT * FROM serials WHERE productId = :productId ORDER BY createdAt DESC")
    fun observeByProductId(productId: Long): Flow<List<SerialEntity>>

    /** یک رکورد جدید ثبت می‌کند و شناسه تولیدشده را برمی‌گرداند. */
    @Insert
    suspend fun insert(entity: SerialEntity): Long

    /** یک رکورد موجود را حذف می‌کند. */
    @Delete
    suspend fun delete(entity: SerialEntity)
}
