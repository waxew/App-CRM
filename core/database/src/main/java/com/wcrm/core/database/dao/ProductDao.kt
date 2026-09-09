package com.wcrm.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.wcrm.core.database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

/**
 * درگاه دسترسی به داده‌های محصول در Room.
 *
 * این لایه فقط مسئول عملیات ذخیره‌سازی است و قوانین کسب‌وکار محصول در Domain باقی می‌مانند.
 */
@Dao
interface ProductDao {

    /** دریافت واکنشی همه محصولات. */
    @Query("SELECT * FROM products ORDER BY createdAt DESC")
    fun getProducts(): Flow<List<ProductEntity>>

    /** دریافت محصول بر اساس شناسه. */
    @Query("SELECT * FROM products WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): ProductEntity?

    /** جستجو در نام یا برند محصول. */
    @Query("SELECT * FROM products WHERE name LIKE '%' || :query || '%' OR brand LIKE '%' || :query || '%'")
    fun search(query: String): Flow<List<ProductEntity>>

    /** ذخیره محصول جدید. */
    @Insert
    suspend fun insert(product: ProductEntity): Long

    /** بروزرسانی محصول. */
    @Update
    suspend fun update(product: ProductEntity)

    /** حذف محصول. */
    @Delete
    suspend fun delete(product: ProductEntity)
}
