package com.wcrm.core.domain.customer

class GetCustomersUseCase(
    private val repository: CustomerRepository
) {
    operator fun invoke() = repository.getCustomers()
}
