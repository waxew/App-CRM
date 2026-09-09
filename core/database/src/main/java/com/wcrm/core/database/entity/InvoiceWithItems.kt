package com.wcrm.core.database.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * نمای رابطه‌ای یک فاکتور همراه با تمام اقلام آن.
 *
 * Room این ساختار را در Queryهای تراکنشی از جدول `invoices` و `invoice_items`
 * می‌سازد و Repository آن را به مدل دامنه [com.wcrm.core.model.Invoice] تبدیل می‌کند.
 */
data class InvoiceWithItems(
    @Embedded
    val invoice: InvoiceEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "invoiceId"
    )
    val items: List<InvoiceItemEntity>
)
