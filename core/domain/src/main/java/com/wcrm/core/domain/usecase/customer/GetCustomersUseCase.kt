package com.wcrm.core.domain.usecase.customer

import com.wcrm.core.domain.repository.CustomerRepository
import com.wcrm.core.model.Customer
import kotlinx.coroutines.flow.Flow

class GetCustomersUseCase(
    private val repository: CustomerRepository
) {
    operator fun invoke(): Flow<List<Customer>> = repository.observeCustomers()
}
