package com.wcrm.core.repository.invoice

import com.wcrm.core.database.entity.InvoiceEntity
import com.wcrm.core.database.entity.InvoiceItemEntity
import com.wcrm.core.database.entity.InvoiceWithItems
import com.wcrm.core.model.Invoice
import com.wcrm.core.model.InvoiceItem
import com.wcrm.core.model.PaymentStatus

/** تبدیل ساختار رابطه‌ای Room به مدل دامنه فاکتور. */
fun InvoiceWithItems.toDomain(): Invoice = Invoice(
    id = invoice.id,
    customerId = invoice.customerId,
    items = items.map { item ->
        InvoiceItem(
            productId = item.productId,
            productName = item.productName,
            quantity = item.quantity,
            unitPrice = item.unitPrice,
            discountAmount = item.discountAmount,
            taxAmount = item.taxAmount
        )
    },
    totalAmount = invoice.totalAmount,
    paymentStatus = runCatching { PaymentStatus.valueOf(invoice.paymentStatus) }
        .getOrDefault(PaymentStatus.UNPAID),
    createdAt = invoice.createdAt,
    updatedAt = invoice.updatedAt
)

/** تبدیل مدل دامنه به سربرگ قابل ذخیره در Room. */
fun Invoice.toEntity(): InvoiceEntity = InvoiceEntity(
    id = id,
    customerId = customerId,
    totalAmount = totalAmount,
    paymentStatus = paymentStatus.name,
    createdAt = createdAt,
    updatedAt = updatedAt
)

/** تبدیل اقلام دامنه به رکوردهای وابسته به شناسه فاکتور. */
fun Invoice.toItemEntities(invoiceId: Long): List<InvoiceItemEntity> = items.map { item ->
    InvoiceItemEntity(
        invoiceId = invoiceId,
        productId = item.productId,
        productName = item.productName,
        quantity = item.quantity,
        unitPrice = item.unitPrice,
        discountAmount = item.discountAmount,
        taxAmount = item.taxAmount
    )
}
