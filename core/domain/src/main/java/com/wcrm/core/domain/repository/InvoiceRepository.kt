package com.wcrm.core.domain.repository

import com.wcrm.core.model.Invoice
import kotlinx.coroutines.flow.Flow

interface InvoiceRepository {
    fun observeInvoices(): Flow<List<Invoice>>
    suspend fun getInvoiceById(id: Long): Invoice?
    suspend fun createInvoice(invoice: Invoice): Long
    suspend fun updateInvoice(invoice: Invoice)
    suspend fun deleteInvoice(id: Long)
}
