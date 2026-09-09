package com.wcrm.core.domain.repository

import com.wcrm.core.model.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {
    fun observeCustomers(): Flow<List<Customer>>
    suspend fun getCustomerById(id: Long): Customer?
    suspend fun addCustomer(customer: Customer): Long
    suspend fun updateCustomer(customer: Customer)
    suspend fun deleteCustomer(id: Long)
    fun searchCustomers(query: String): Flow<List<Customer>>
}
