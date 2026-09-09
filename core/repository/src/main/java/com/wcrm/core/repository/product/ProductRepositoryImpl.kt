package com.wcrm.core.repository.product

import com.wcrm.core.domain.repository.ProductRepository
import javax.inject.Inject

/**
 * پیاده‌سازی Repository محصول در لایه داده.
 *
 * این کلاس باید قرارداد ProductRepository را به ProductDao و مدل‌های Room متصل کند
 * و تبدیل بین ProductEntity و مدل دامنه Product را انجام دهد.
 *
 * اتصال عملیاتی کامل به Room هنوز در این مرحله تکمیل نشده و در فاز اتصال
 * Repository به DAO پیاده‌سازی خواهد شد.
 */
class ProductRepositoryImpl @Inject constructor() : ProductRepository {
    // عملیات واقعی داده‌های محصول در مرحله اتصال به ProductDao تکمیل می‌شود.
}
