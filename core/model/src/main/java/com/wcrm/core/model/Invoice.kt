package com.wcrm.core.model

data class InvoiceItem(
    val productId: Long,
    val productName: String,
    val quantity: Int,
    val unitPrice: Long,
    val discountAmount: Long = 0,
    val taxAmount: Long = 0
) {
    val lineTotal: Long
        get() = (unitPrice * quantity) - discountAmount + taxAmount
}

enum class PaymentStatus {
    UNPAID,
    PARTIALLY_PAID,
    PAID,
    REFUNDED
}

data class Invoice(
    val id: Long = 0,
    val customerId: Long? = null,
    val items: List<InvoiceItem> = emptyList(),
    val totalAmount: Long = items.sumOf { it.lineTotal },
    val paymentStatus: PaymentStatus = PaymentStatus.UNPAID,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
