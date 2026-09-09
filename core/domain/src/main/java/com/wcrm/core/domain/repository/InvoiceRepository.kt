package com.wcrm.core.domain.repository

import com.wcrm.core.model.Invoice
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد دسترسی به داده‌های فاکتور در لایه Domain.
 *
 * این قرارداد عملیات پایه چرخه عمر فاکتور را تعریف می‌کند و لایه Domain را از
 * جزئیات Room یا هر منبع داده دیگر مستقل نگه می‌دارد.
 */
interface InvoiceRepository {
    /** جریان واکنشی فهرست تمام فاکتورها را منتشر می‌کند. */
    fun observeInvoices(): Flow<List<Invoice>>

    /** فاکتور را با شناسه یکتا بازیابی می‌کند یا در صورت نبودن null برمی‌گرداند. */
    suspend fun getInvoiceById(id: Long): Invoice?

    /** فاکتور جدید را ثبت کرده و شناسه ایجادشده را برمی‌گرداند. */
    suspend fun createInvoice(invoice: Invoice): Long

    /** اطلاعات فاکتور موجود را به‌روزرسانی می‌کند. */
    suspend fun updateInvoice(invoice: Invoice)

    /** فاکتور را بر اساس شناسه حذف می‌کند. */
    suspend fun deleteInvoice(id: Long)
}
