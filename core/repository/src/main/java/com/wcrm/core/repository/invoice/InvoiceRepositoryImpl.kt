package com.wcrm.core.repository.invoice

import com.wcrm.core.domain.repository.InvoiceRepository
import javax.inject.Inject

/**
 * پیاده‌سازی Repository فاکتور در لایه داده.
 *
 * این کلاس باید قرارداد InvoiceRepository را به InvoiceDao متصل کند و تبدیل
 * بین InvoiceEntity و مدل دامنه Invoice را بر عهده داشته باشد.
 *
 * اتصال عملیاتی کامل به Room هنوز تکمیل نشده و در فاز بعدی توسعه انجام می‌شود.
 */
class InvoiceRepositoryImpl @Inject constructor() : InvoiceRepository {
    // عملیات واقعی داده‌های فاکتور در مرحله اتصال به InvoiceDao تکمیل می‌شود.
}
