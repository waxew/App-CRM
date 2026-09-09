package com.wcrm.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.wcrm.core.database.entity.RepairEntity
import kotlinx.coroutines.flow.Flow

/**
 * رابط دسترسی به داده‌های تیکت‌های تعمیر در Room.
 *
 * عملیات ذخیره‌سازی و بازیابی تعمیرات در این DAO متمرکز است و قوانین تجاری
 * مربوط به وضعیت‌ها، هزینه و تحویل دستگاه در لایه Domain باقی می‌مانند.
 */
@Dao
interface RepairDao {

    /** تمام تیکت‌ها را از جدیدترین به قدیمی‌ترین منتشر می‌کند. */
    @Query("SELECT * FROM repairs ORDER BY createdAt DESC")
    fun observeRepairs(): Flow<List<RepairEntity>>

    /** یک تیکت را با شناسه یکتا دریافت می‌کند. */
    @Query("SELECT * FROM repairs WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): RepairEntity?

    /** تیکت‌های متعلق به یک مشتری را منتشر می‌کند. */
    @Query("SELECT * FROM repairs WHERE customerId = :customerId ORDER BY createdAt DESC")
    fun observeByCustomer(customerId: Long): Flow<List<RepairEntity>>

    /** تیکت جدید ثبت می‌کند. */
    @Insert
    suspend fun insert(entity: RepairEntity): Long

    /** تیکت موجود را به‌روزرسانی می‌کند. */
    @Update
    suspend fun update(entity: RepairEntity)

    /** تیکت را حذف می‌کند. */
    @Delete
    suspend fun delete(entity: RepairEntity)
}
