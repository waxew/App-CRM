package com.wcrm.core.domain.customer

import com.wcrm.core.model.customer.Customer

object CustomerMapper {
    fun toDomain(entity: Customer): Customer = entity
}
