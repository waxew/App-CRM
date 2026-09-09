package com.wcrm.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
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

    /**
     * تمام مشتری‌ها را به صورت واکنشی و بر اساس جدیدترین رکورد برمی‌گرداند.
     *
     * استفاده از [Flow] باعث می‌شود تغییرات جدول به صورت خودکار به لایه‌های بالاتر
     * منتقل شود و UI بتواند بدون Polling دوباره‌سازی شود.
     */
    @Query("SELECT * FROM customers ORDER BY createdAt DESC")
    fun getCustomers(): Flow<List<CustomerEntity>>

    /**
     * یک رکورد مشتری را در جدول ذخیره می‌کند.
     *
     * اعتبارسنجی داده باید قبل از رسیدن به این لایه و در Domain انجام شده باشد.
     */
    @Insert
    suspend fun insert(customer: CustomerEntity)
}
