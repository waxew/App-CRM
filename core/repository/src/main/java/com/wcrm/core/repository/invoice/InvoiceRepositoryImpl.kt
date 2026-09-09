package com.wcrm.core.repository.invoice

import androidx.room.withTransaction
import com.wcrm.core.database.AppDatabase
import com.wcrm.core.database.dao.InvoiceDao
import com.wcrm.core.domain.repository.InvoiceRepository
import com.wcrm.core.model.Invoice
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * پیاده‌سازی Repository فاکتور بر پایه Room.
 *
 * عملیات چندمرحله‌ای ایجاد و ویرایش فاکتور داخل Transaction اجرا می‌شوند تا سربرگ
 * و اقلام هر فاکتور همیشه با هم و به‌صورت سازگار ذخیره شوند.
 */
class InvoiceRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val invoiceDao: InvoiceDao
) : InvoiceRepository {

    /** جریان فاکتورها را از Entityهای Room به مدل دامنه تبدیل می‌کند. */
    override fun observeInvoices(): Flow<List<Invoice>> =
        invoiceDao.observeInvoices().map { invoices -> invoices.map { it.toDomain() } }

    /** فاکتور و اقلام آن را با شناسه یکتا بازیابی می‌کند. */
    override suspend fun getInvoiceById(id: Long): Invoice? =
        invoiceDao.getInvoiceById(id)?.toDomain()

    /** فاکتور جدید را به‌صورت اتمیک همراه تمام اقلام ثبت می‌کند. */
    override suspend fun createInvoice(invoice: Invoice): Long = database.withTransaction {
        val invoiceId = invoiceDao.insertInvoice(invoice.toEntity())
        val itemEntities = invoice.toItemEntities(invoiceId)
        if (itemEntities.isNotEmpty()) {
            invoiceDao.insertItems(itemEntities)
        }
        invoiceId
    }

    /** سربرگ و مجموعه اقلام فاکتور موجود را در یک Transaction بروزرسانی می‌کند. */
    override suspend fun updateInvoice(invoice: Invoice) {
        database.withTransaction {
            invoiceDao.updateInvoice(invoice.toEntity())
            invoiceDao.deleteItemsForInvoice(invoice.id)
            val itemEntities = invoice.toItemEntities(invoice.id)
            if (itemEntities.isNotEmpty()) {
                invoiceDao.insertItems(itemEntities)
            }
        }
    }

    /** فاکتور را حذف می‌کند؛ اقلام وابسته به‌صورت Cascade پاک می‌شوند. */
    override suspend fun deleteInvoice(id: Long) {
        invoiceDao.deleteInvoice(id)
    }
}
