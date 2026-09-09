package com.wcrm.core.domain.repository

import com.wcrm.core.model.Product
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد دسترسی به داده‌های محصول در لایه Domain.
 *
 * Core فقط این قرارداد را می‌شناسد و از جزئیات ذخیره‌سازی مستقل می‌ماند؛
 * بنابراین Business Profileها و Featureها می‌توانند بدون وابستگی مستقیم به Room
 * از عملیات استاندارد محصول استفاده کنند.
 */
interface ProductRepository {
    /** جریان واکنشی فهرست محصولات را منتشر می‌کند. */
    fun observeProducts(): Flow<List<Product>>

    /** محصول را با شناسه یکتا بازیابی می‌کند یا در صورت نبودن null برمی‌گرداند. */
    suspend fun getProductById(id: Long): Product?

    /** محصول جدید را ذخیره کرده و شناسه ایجادشده را برمی‌گرداند. */
    suspend fun addProduct(product: Product): Long

    /** مشخصات محصول موجود را به‌روزرسانی می‌کند. */
    suspend fun updateProduct(product: Product)

    /** محصول را بر اساس شناسه حذف می‌کند. */
    suspend fun deleteProduct(id: Long)

    /** نتایج جست‌وجوی محصول را به صورت واکنشی منتشر می‌کند. */
    fun searchProducts(query: String): Flow<List<Product>>
}
