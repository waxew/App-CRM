package com.wcrm.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.wcrm.core.database.entity.CustomerEntity
import kotlinx.coroutines.flow.Flow

/**
 * رابط دسترسی به داده‌های مشتری در پایگاه‌داده Room.
 *
 * این DAO فقط مسئول اجرای عملیات مستقیم روی جدول `customers` است و نباید
 * منطق تجاری مربوط به مشتری را در خود نگه دارد. لایه Repository داده‌های این
 * بخش را به مدل‌های Domain تبدیل می‌کند و در اختیار UseCaseها قرار می‌دهد.
 */
@Dao
interface CustomerDao {

    /** تمام مشتری‌ها را به صورت واکنشی و بر اساس جدیدترین رکورد برمی‌گرداند. */
    @Query("SELECT * FROM customers ORDER BY createdAt DESC")
    fun getCustomers(): Flow<List<CustomerEntity>>

    /** مشتری مشخص‌شده را بر اساس شناسه بازیابی می‌کند. */
    @Query("SELECT * FROM customers WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): CustomerEntity?

    /** رکورد مشتری را ذخیره کرده و شناسه ثبت‌شده را برمی‌گرداند. */
    @Insert
    suspend fun insert(customer: CustomerEntity): Long

    /** رکورد موجود مشتری را به‌روزرسانی می‌کند. */
    @Update
    suspend fun update(customer: CustomerEntity)

    /** مشتری را بر اساس شناسه حذف می‌کند. */
    @Query("DELETE FROM customers WHERE id = :id")
    suspend fun deleteById(id: Long)

    /** جست‌وجوی واکنشی بر اساس نام، تلفن، موبایل یا ایمیل. */
    @Query(
        """
        SELECT * FROM customers
        WHERE name LIKE '%' || :query || '%'
           OR phone LIKE '%' || :query || '%'
           OR mobile LIKE '%' || :query || '%'
           OR email LIKE '%' || :query || '%'
        ORDER BY createdAt DESC
        """
    )
    fun search(query: String): Flow<List<CustomerEntity>>
}
