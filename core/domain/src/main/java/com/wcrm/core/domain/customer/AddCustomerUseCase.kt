package com.wcrm.core.domain.customer

import com.wcrm.core.domain.repository.CustomerRepository
import com.wcrm.core.model.customer.Customer
import javax.inject.Inject

class AddCustomerUseCase @Inject constructor(
    private val repository: CustomerRepository
) {
    suspend operator fun invoke(customer: Customer) {
        repository.addCustomer(customer)
    }
}
