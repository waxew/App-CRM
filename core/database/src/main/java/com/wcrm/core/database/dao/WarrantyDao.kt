package com.wcrm.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.wcrm.core.database.entity.WarrantyEntity
import kotlinx.coroutines.flow.Flow

/**
 * درگاه دسترسی به داده‌های گارانتی در پایگاه‌داده Room.
 *
 * این DAO فقط عملیات ذخیره و بازیابی مستقیم را انجام می‌دهد و قوانین تجاری
 * مربوط به اعتبار گارانتی در لایه Domain باقی می‌مانند.
 */
@Dao
interface WarrantyDao {

    /** جریان واکنشی تمام گارانتی‌ها را بر اساس جدیدترین رکورد منتشر می‌کند. */
    @Query("SELECT * FROM warranties ORDER BY startDate DESC")
    fun observeWarranties(): Flow<List<WarrantyEntity>>

    /** یک گارانتی را بر اساس شناسه داخلی بازیابی می‌کند. */
    @Query("SELECT * FROM warranties WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): WarrantyEntity?

    /** گارانتی مرتبط با شماره سریال را بازیابی می‌کند. */
    @Query("SELECT * FROM warranties WHERE serialNumber = :serialNumber LIMIT 1")
    suspend fun getBySerialNumber(serialNumber: String): WarrantyEntity?

    /** رکورد گارانتی جدید را ثبت می‌کند. */
    @Insert
    suspend fun insert(entity: WarrantyEntity): Long

    /** رکورد گارانتی موجود را به‌روزرسانی می‌کند. */
    @Update
    suspend fun update(entity: WarrantyEntity)

    /** گارانتی را بر اساس شناسه داخلی حذف می‌کند. */
    @Query("DELETE FROM warranties WHERE id = :id")
    suspend fun deleteById(id: Long)
}
