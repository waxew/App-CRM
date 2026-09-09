package com.wcrm.core.domain.customer

import com.wcrm.core.model.customer.Customer

class ValidateCustomerUseCase {
    operator fun invoke(customer: Customer): CustomerValidationResult {
        return if (customer.name.isBlank()) {
            CustomerValidationResult.Invalid("Customer name is required")
        } else {
            CustomerValidationResult.Valid
        }
    }
}
