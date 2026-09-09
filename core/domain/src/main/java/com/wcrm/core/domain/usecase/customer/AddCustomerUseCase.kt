package com.wcrm.core.domain.usecase.customer

import com.wcrm.core.domain.repository.CustomerRepository
import com.wcrm.core.model.Customer

class AddCustomerUseCase(
    private val repository: CustomerRepository
) {
    suspend operator fun invoke(customer: Customer): Long = repository.addCustomer(customer)
}
