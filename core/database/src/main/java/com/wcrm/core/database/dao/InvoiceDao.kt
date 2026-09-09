package com.wcrm.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.wcrm.core.database.entity.InvoiceEntity
import com.wcrm.core.database.entity.InvoiceItemEntity
import com.wcrm.core.database.entity.InvoiceWithItems
import kotlinx.coroutines.flow.Flow

/**
 * درگاه دسترسی به فاکتورها و اقلام آن‌ها در Room.
 *
 * عملیات چندمرحله‌ای ایجاد و ویرایش فاکتور از Repository فراخوانی می‌شوند، اما Queryهای
 * رابطه‌ای این DAO همیشه سربرگ و اقلام را به‌صورت یک نمای منسجم برمی‌گردانند.
 */
@Dao
interface InvoiceDao {

    /** تمام فاکتورها را همراه اقلام، از جدیدترین به قدیمی‌ترین منتشر می‌کند. */
    @Transaction
    @Query("SELECT * FROM invoices ORDER BY createdAt DESC")
    fun observeInvoices(): Flow<List<InvoiceWithItems>>

    /** یک فاکتور را همراه اقلام آن بر اساس شناسه بازیابی می‌کند. */
    @Transaction
    @Query("SELECT * FROM invoices WHERE id = :id LIMIT 1")
    suspend fun getInvoiceById(id: Long): InvoiceWithItems?

    /** سربرگ فاکتور را درج کرده و شناسه تولیدشده را برمی‌گرداند. */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertInvoice(invoice: InvoiceEntity): Long

    /** تمام اقلام یک فاکتور را در یک مرحله درج می‌کند. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<InvoiceItemEntity>)

    /** سربرگ فاکتور موجود را بروزرسانی می‌کند. */
    @Update
    suspend fun updateInvoice(invoice: InvoiceEntity)

    /** تمام اقلام فعلی یک فاکتور را پیش از جایگزینی حذف می‌کند. */
    @Query("DELETE FROM invoice_items WHERE invoiceId = :invoiceId")
    suspend fun deleteItemsForInvoice(invoiceId: Long)

    /** حذف سربرگ؛ به دلیل ForeignKey، اقلام نیز به‌صورت Cascade حذف می‌شوند. */
    @Query("DELETE FROM invoices WHERE id = :id")
    suspend fun deleteInvoice(id: Long)
}
